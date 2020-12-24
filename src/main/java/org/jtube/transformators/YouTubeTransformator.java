package org.jtube.transformators;

import org.jtube.data.Source;
import org.jtube.data.SourceData;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.data.youtube.YouTubeSourceData;

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
		YouTubeSourceData youTubeSourceData = (YouTubeSourceData) sourceData;
		return new ProductData()
				.withTitle(youTubeSourceData.getVideoDetails().getTitle())
				.withSource(Source.YOUTUBE)
				.withMultiMediaStreams(
						youTubeSourceData.getStreamingData().getAllFormats().stream()
						.map(format -> new MultiMediaStream()
								.withType(format.getMediaFormatType())
								.withResolution(format.getQualityLabel())
								.withFrameRate(format.getFps())
								.withAudioSampleRate(format.getAudioSampleRate())
								.withBitRate(format.getBitrate())
								.withUrls(Stream.of(format.getUrl()).collect(Collectors.toList()))
						).collect(Collectors.toList())
				);
	}

}
