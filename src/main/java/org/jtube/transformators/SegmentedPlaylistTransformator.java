package org.jtube.transformators;

import io.lindstrom.m3u8.model.MediaSegment;
import org.apache.log4j.Logger;
import org.jtube.Processor;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.Source;
import org.jtube.data.SourceData;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.data.segmentedPlaylist.SegmentedPlaylistSourceData;
import org.jtube.data.youtube.QualityLabel;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SegmentedPlaylistTransformator implements Transformator {

	final static Logger logger = Logger.getLogger(SegmentedPlaylistTransformator.class);

	@Override
	public ProductData transform(SourceData sourceData) {
		SegmentedPlaylistSourceData segmentedPlaylistSourceData = (SegmentedPlaylistSourceData) sourceData;
		URL streamsBaseUrl = segmentedPlaylistSourceData.getUriMasterPlaylistMap().keySet().stream().findFirst().get();
		return new ProductData()
				.withTitle(urlToTitle(streamsBaseUrl))
				.withSource(Source.SEGMENTED_PLAYLIST)
				.withMultiMediaStreams(
						segmentedPlaylistSourceData.getUriMasterPlaylistMap().values().stream().findFirst().get().variants().stream()
								.map((variant) -> {
									logger.debug(variant);
									URL streamBaseUrl = enrichUrl(streamsBaseUrl, variant.uri());
									logger.debug(streamBaseUrl);
									return new MultiMediaStream()
											.withType(MultimediaFormatType.AUDIO_VIDEO)
											.withResolution(QualityLabel.valueOf("" + variant.resolution().get().height()))
											.withBitRate(variant.bandwidth())
											.withUrls(
													segmentedPlaylistSourceData.getUriMediaPlaylistMap().get(streamBaseUrl).mediaSegments().stream()
															.map(MediaSegment::uri).map((uri) -> {return enrichUrl(streamBaseUrl, "/"+uri);})
															.collect(Collectors.toList())
											);
										}
								).collect(Collectors.toList())
				);
	}

	private String urlToTitle(URL url) {
		return Arrays.stream(url.getFile().replace("/index.m3u8", "").replace("/hls", "").split("/"))
				.reduce((s, s2) -> s2).orElse(null);
	}

	private URL enrichUrl(URL masterPlaylistURL, String suffix) {
		try {
			return new URL(masterPlaylistURL.getProtocol(), masterPlaylistURL.getHost(), masterPlaylistURL.getPort()
					, Paths.get(masterPlaylistURL.getFile()).getParent().toString() + suffix.replaceFirst("^[.]", ""));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

}
