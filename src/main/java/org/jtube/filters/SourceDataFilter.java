package org.jtube.filters;

import org.jsoup.nodes.Document;

public interface SourceDataFilter {

	String filterSourceData(Document document);

}
