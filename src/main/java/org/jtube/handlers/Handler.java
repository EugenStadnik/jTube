package org.jtube.handlers;

import org.jsoup.nodes.Document;
import org.jtube.data.result.ProductData;

import java.io.IOException;

public interface Handler {

	ProductData handle(Document document) throws IOException;

}
