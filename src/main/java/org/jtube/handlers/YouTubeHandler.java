package org.jtube.handlers;

import org.jsoup.nodes.Document;
import org.jtube.data.objectMappers.YouTubeSourceDataMapper;
import org.jtube.data.result.ProductData;
import org.jtube.transformators.YouTubeTransformator;
import org.jtube.utils.html.YoutubeSourceDataFilter;

import java.io.IOException;

public class YouTubeHandler implements Handler {
	@Override
	public ProductData handle(Document document) throws IOException {
		return YouTubeTransformator
				.getInstance()
				.transform(
						YouTubeSourceDataMapper
								.getInstance()
								.parseSourceData(
										YoutubeSourceDataFilter
												.getInstance()
												.filterSourceData(document)
								)
				);
	}
}
