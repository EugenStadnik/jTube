package org.jtube.handlers;

import org.jsoup.nodes.Document;
import org.jtube.data.objectMappers.VimeoSourceDataMapper;
import org.jtube.data.result.ProductData;
import org.jtube.filters.VimeoSourceDataFilter;
import org.jtube.transformators.VimeoTransformator;

import java.io.IOException;

public class VimeoHandler implements Handler {

	private static VimeoHandler instance;

	private VimeoHandler() {}

	public static synchronized VimeoHandler getInstance() {
		if(instance == null) {
			instance = new VimeoHandler();
		}
		return instance;
	}

	@Override
	public ProductData handle(Document document) throws IOException {
		return VimeoTransformator
				.getInstance()
				.transform(
						VimeoSourceDataMapper
								.getInstance()
								.parseSourceData(
										VimeoSourceDataFilter
												.getInstance()
												.filterSourceData(document)
								)
				);
	}
}
