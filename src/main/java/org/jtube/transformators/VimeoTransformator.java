package org.jtube.transformators;

import org.apache.log4j.Logger;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.Source;
import org.jtube.data.SourceData;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.data.vimeo.VimeoSourceData;
import org.jtube.data.youtube.QualityLabel;
import org.jtube.utils.Util;
import org.jtube.utils.net.UrlUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VimeoTransformator implements Transformator {

	private static final Logger LOGGER = Logger.getLogger(VimeoTransformator.class);

	private static VimeoTransformator instance;

	private VimeoTransformator() {}

	public static synchronized VimeoTransformator getInstance() {
		if(instance == null) {
			instance = new VimeoTransformator();
		}
		return instance;
	}

	@Override
	public ProductData transform(SourceData sourceData) {
		if(sourceData == null) {return null;}
		VimeoSourceData vimeoSourceData = (VimeoSourceData) sourceData;
		List<MultiMediaStream> multiMediaStreams = transformProgressive(vimeoSourceData);
		multiMediaStreams.addAll(transformDash(vimeoSourceData));
		return new ProductData()
				.withTitle(Util.normalizeTitle(vimeoSourceData.getPlayerData().getVideo().getTitle()))
				.withSource(Source.VIMEO)
				.withMultiMediaStreams(multiMediaStreams);
	}

	private List<MultiMediaStream> transformProgressive(VimeoSourceData vimeoSourceData) {
		if(vimeoSourceData.getPlayerData().getRequest().getFiles().getProgressive() != null
				&& !vimeoSourceData.getPlayerData().getRequest().getFiles().getProgressive().isEmpty()) {
			return vimeoSourceData.getPlayerData().getRequest().getFiles().getProgressive().stream()
					.map((progressive) -> {
								String id = progressive.getId();
								org.jtube.data.vimeo.streams.Stream video = vimeoSourceData.getStreams().getVideo().stream()
										.filter(stream -> id.contains(stream.getId())).findFirst().orElse(null);
								org.jtube.data.vimeo.streams.Stream audio = vimeoSourceData.getStreams().getAudio().stream()
										.filter(stream -> id.contains(stream.getId())).findFirst().orElse(null);
								return new MultiMediaStream()
										.withType(MultimediaFormatType.AUDIO_VIDEO)
										.withResolution(QualityLabel.valueOf(progressive.getQuality() != null
												? progressive.getQuality() : "" + (int)(progressive.getWidth()/1.777777777777)))
										.withFrameRate((long) progressive.getFps())
										.withAudioSampleRate(audio != null ? "" + audio.getSampleRate() : null)
										.withBitRate(audio != null && video != null
												? audio.getBitrate() + video.getBitrate()
												: video != null ? video.getBitrate() : audio != null ? audio.getBitrate() : 0)
										.withAddCodec(video != null ? video.getCodecs() : null)
										.withAddCodec(audio != null ? audio.getCodecs() : null)
										.withFileContainer(progressive.getMime()
												.replaceFirst("^[audiove]{5}/", ""))
										.withUrls(Stream.of(progressive.getUrl()).collect(Collectors.toList()));
							}
					).collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}

	private List<MultiMediaStream> transformDash(VimeoSourceData vimeoSourceData) {
		List<MultiMediaStream> result = new ArrayList<>();
		URL allStreamsBaseUrl = UrlUtils.getInstance().enrichUrl(
				vimeoSourceData.getPlayerData().getRequest().getFiles().getDash().defaultCdnObject().getUrl()
				, vimeoSourceData.getStreams().getBaseUrl(), true);
		if((vimeoSourceData.getStreams() != null
				&& vimeoSourceData.getStreams().getVideo() != null
				&& !vimeoSourceData.getStreams().getVideo().isEmpty())
				|| (vimeoSourceData.getStreams() != null
				&& vimeoSourceData.getStreams().getAudio() != null
				&& !vimeoSourceData.getStreams().getAudio().isEmpty())) {
			result.addAll(Stream.concat(
					vimeoSourceData.getStreams().getVideo().stream()
					, vimeoSourceData.getStreams().getAudio().stream()
			)
					.map((vimeoStream) -> {
				MultimediaFormatType multimediaFormatType = MultimediaFormatType.valueOf(
						vimeoStream.getMimeType().replaceFirst("/.*$", "").toUpperCase()
				);
				String id = vimeoStream.getId();	//1ddc9693
				org.jtube.data.vimeo.playerData.Stream stream
						= vimeoSourceData.getPlayerData().getRequest().getFiles().getDash().getStreams().stream()
						.filter(stream1 -> stream1.getId().contains(id))
						.findFirst().orElse(null);	//1ddc9693-8515-4518-9234-7905a66f482b
				URL videoStreamBaseUrl = UrlUtils.getInstance().enrichUrl(allStreamsBaseUrl, vimeoStream.getBaseUrl(), false);
				QualityLabel qualityLabel = stream.getQuality() != null ? QualityLabel.valueOf(stream.getQuality()) : null;
				return new MultiMediaStream()
						.withType(multimediaFormatType)
						.withResolution(qualityLabel)
						.withFrameRate((long)vimeoStream.getFramerate())
						.withAudioSampleRate("" + vimeoStream.getSampleRate())
						.withBitRate(vimeoStream.getBitrate())
						.withCodecs(Stream.of(vimeoStream.getCodecs().split(",")).collect(Collectors.toList()))
						.withFileContainer(vimeoStream.getMimeType().replaceFirst("^[audiove]{5}/", ""))
						.withUrls(vimeoStream.getSegments().stream()
								.map(segment -> UrlUtils.getInstance().enrichUrl(videoStreamBaseUrl, segment.getUrl(), false))
								.collect(Collectors.toList()))
						.withInitSegmentBase64(vimeoStream.getInitSegment());
			}).collect(Collectors.toList()));
		}
		return result;
	}

}
