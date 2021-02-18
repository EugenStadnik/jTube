package org.jtube.handlers.segmentedPlaylist;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jtube.data.result.ProductData;
import org.jtube.handlers.Handler;
import org.jtube.utils.net.UrlLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

public class EneyidaHandler implements Handler {

	private static final Logger LOGGER = Logger.getLogger(EneyidaHandler.class);
	private static EneyidaHandler instance;
	private static final SegmentedPlaylistHandler segmentedPlaylistHandler = SegmentedPlaylistHandler.getInstance();

	private EneyidaHandler() {}

	public static synchronized EneyidaHandler getInstance() {
		if(instance == null) {
			instance = new EneyidaHandler();
		}
		return instance;
	}

	@Override
	public ProductData handle(Document document) throws IOException {
		String source = document.getElementsByAttributeValueStarting("class", "video_box")
				.stream().filter(element -> !"trailer_place".equals(element.id()))
				.map(Element::children).flatMap(Collection::stream)
				.map(element -> element.attr("src")).findFirst().orElse(null);
		if(source != null) {
			LOGGER.info("The html source for " + source + " video is parsed successfully.");
		} else {
			LOGGER.warn("The html source of current url is not parsed.");
			return null;
		}
		Document subDocument = UrlLoader.getInstance().load(new URL(source));
		return segmentedPlaylistHandler.handle(subDocument);
	}
}
