package org.jtube.handlers;

import org.jsoup.nodes.Document;
import org.jtube.data.objectMappers.SegmentedPlaylistSourceDataMapper;
import org.jtube.data.result.ProductData;
import org.jtube.transformators.SegmentedPlaylistTransformator;
import org.jtube.utils.html.SegmentedPlaylistSourceDataFilter;

import java.io.IOException;

public class SegmentedPlaylistHandler implements Handler {
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
