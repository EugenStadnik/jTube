package org.jtube.transformators;

import org.jtube.data.Source;
import org.jtube.data.SourceData;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.data.youtube.YouTubeSourceData;
import org.jtube.utils.Util;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YouTubeTransformator implements Transformator {

	private static YouTubeTransformator instance;

	private YouTubeTransformator() {}

	public static synchronized YouTubeTransformator getInstance() {
		if(instance == null) {
			instance = new YouTubeTransformator();
		}
		return instance;
	}

	@Override
	public ProductData transform(SourceData sourceData) {
		if(sourceData == null) {return null;}
		YouTubeSourceData youTubeSourceData = (YouTubeSourceData) sourceData;
		return new ProductData()
				.withTitle(Util.normalizeTitle(youTubeSourceData.getVideoDetails().getTitle()))
				.withSource(Source.YOUTUBE)
				.withMultiMediaStreams(
						youTubeSourceData.getStreamingData().getAllFormats().stream()
						.map(format ->
								new MultiMediaStream()
								.withType(format.getMediaFormatType())
								.withResolution(format.getQualityLabel())
								.withFrameRate((long) format.getFps())
								.withAudioSampleRate(format.getAudioSampleRate())
								.withBitRate(format.getBitrate())
								.withCodecs(Arrays.asList(format.getMimeType()
										.replaceFirst("^.*;[ ]?codecs=\"", "")
										.replaceFirst("\"$", "")
										.split(",[ ]?")))
								.withFileContainer(format.getMimeType()
										.replaceFirst("^[audiove]{5}/", "")
										.replaceFirst(";[ ]?codecs=\".*\"$", ""))
								.withUrls(Stream.of(format.getUrl()).collect(Collectors.toList()))
						).collect(Collectors.toList())
				);
	}

}
