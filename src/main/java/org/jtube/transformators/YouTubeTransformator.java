package org.jtube.transformators;

import org.jtube.data.Source;
import org.jtube.data.SourceData;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.data.youtube.YouTubeSourceData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YouTubeTransformator implements Transformator {
	@Override
	public ProductData transform(SourceData sourceData) {
		YouTubeSourceData youTubeSourceData = (YouTubeSourceData) sourceData;
		return new ProductData()
				.withTitle(youTubeSourceData.getVideoDetails().getTitle())
				.withSource(Source.YOUTUBE)
				.withMultiMediaStreams(
						youTubeSourceData.getStreamingData().getFormats().stream()
						.map(format -> new MultiMediaStream()
								.withType(format.getMediaFormatType())
								.withResolution(format.getQualityLabel())
								.withFrameRate(format.getAverageBitrate())
								.withAudioSampleRate(Integer.parseInt(format.getAudioSampleRate()))
								.withBitRate(format.getAverageBitrate())
								.withUrls(Stream.of(format.getUrl()).collect(Collectors.toList()))
						).collect(Collectors.toList())
				);
	}

}
