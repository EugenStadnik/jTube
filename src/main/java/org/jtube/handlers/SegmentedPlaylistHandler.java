package org.jtube.handlers;

import org.jsoup.nodes.Document;
import org.jtube.data.objectMappers.SegmentedPlaylistSourceDataMapper;
import org.jtube.data.result.ProductData;
import org.jtube.transformators.SegmentedPlaylistTransformator;
import org.jtube.utils.html.SegmentedPlaylistSourceDataFilter;

import java.io.IOException;

public class SegmentedPlaylistHandler implements Handler {

	private static SegmentedPlaylistHandler instance;

	private SegmentedPlaylistHandler() {}

	public static synchronized SegmentedPlaylistHandler getInstance() {
		if(instance == null) {
			instance = new SegmentedPlaylistHandler();
		}
		return instance;
	}

	@Override
	public ProductData handle(Document document) throws IOException {
		return SegmentedPlaylistTransformator
				.getInstance()
				.transform(
						SegmentedPlaylistSourceDataMapper
								.getInstance()
								.parseSourceData(
										SegmentedPlaylistSourceDataFilter
												.getInstance()
												.filterSourceData(document)
								)
				);
	}
}
