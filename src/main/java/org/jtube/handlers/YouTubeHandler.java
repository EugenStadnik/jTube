package org.jtube.handlers;

import org.jsoup.nodes.Document;
import org.jtube.data.objectMappers.YouTubeSourceDataMapper;
import org.jtube.data.result.ProductData;
import org.jtube.transformators.YouTubeTransformator;
import org.jtube.filters.YoutubeSourceDataFilter;

import java.io.IOException;

public class YouTubeHandler implements Handler {

	private static YouTubeHandler instance;

	private YouTubeHandler() {}

	public static synchronized YouTubeHandler getInstance() {
		if(instance == null) {
			instance = new YouTubeHandler();
		}
		return instance;
	}

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
