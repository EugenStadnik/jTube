package org.jtube.transformators;

import io.lindstrom.m3u8.model.MediaSegment;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.Source;
import org.jtube.data.SourceData;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.data.segmentedPlaylist.SegmentedPlaylistSourceData;
import org.jtube.data.youtube.QualityLabel;
import org.jtube.utils.net.UrlUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SegmentedPlaylistTransformator implements Transformator {

	private static SegmentedPlaylistTransformator instance;

	private final UrlUtils urlUtils = UrlUtils.getInstance();

	private SegmentedPlaylistTransformator() {}

	public static synchronized SegmentedPlaylistTransformator getInstance() {
		if(instance == null) {
			instance = new SegmentedPlaylistTransformator();
		}
		return instance;
	}

	@Override
	public ProductData transform(SourceData sourceData) {
		if(sourceData == null) {return null;}
		SegmentedPlaylistSourceData segmentedPlaylistSourceData = (SegmentedPlaylistSourceData) sourceData;
		URL streamsBaseUrl = segmentedPlaylistSourceData.getUriMasterPlaylistMap().keySet().stream().findFirst().orElse(null);
		return new ProductData()
				.withTitle(urlUtils.masterPlaylistUrlToTitle(Objects.requireNonNull(streamsBaseUrl)).replaceFirst("[_]?\\d*$", ""))
				.withSource(Source.SEGMENTED_PLAYLIST)
				.withMultiMediaStreams(
						Objects.requireNonNull(segmentedPlaylistSourceData.getUriMasterPlaylistMap().values().stream().findFirst().orElse(null)).variants().stream()
								.map((variant) -> {
									URL streamBaseUrl = urlUtils.enrichUrl(streamsBaseUrl, variant.uri(), true);
									String m3u8Uri = segmentedPlaylistSourceData.getUriMediaPlaylistMap().get(streamBaseUrl).mediaSegments().get(0).uri();
									List<String> resultCodecs = new ArrayList<>();
									if(m3u8Uri.contains(".ts")) {
										resultCodecs.add("mpeg-ts");
									}
									return new MultiMediaStream()
											.withType(MultimediaFormatType.AUDIO_VIDEO)
											.withResolution(QualityLabel.valueOf("" + (int)(Objects.requireNonNull(variant.resolution().orElse(null)).width()/1.777777777777777)))
											.withBitRate(variant.bandwidth())
											.withFrameRate(variant.frameRate().map(Double::longValue).orElse(null))
											.withCodecs(variant.codecs().isEmpty() && m3u8Uri.contains(".ts") ? resultCodecs : variant.codecs())
											.withFileContainer(m3u8Uri.replaceFirst("^.+\\.", ""))
											.withUrls(
													segmentedPlaylistSourceData.getUriMediaPlaylistMap().get(streamBaseUrl).mediaSegments().stream()
															.map(MediaSegment::uri).map(uri -> urlUtils.enrichUrl(streamBaseUrl, "/" + uri, true)
													).collect(Collectors.toList())
											);
										}
								).collect(Collectors.toList())
				);
	}

}
