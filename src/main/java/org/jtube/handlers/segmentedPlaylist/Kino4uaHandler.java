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

public class Kino4uaHandler implements Handler {

	private static final Logger LOGGER = Logger.getLogger(Kino4uaHandler.class);
	private static Kino4uaHandler instance;
	private static final SegmentedPlaylistHandler segmentedPlaylistHandler = SegmentedPlaylistHandler.getInstance();

	private Kino4uaHandler() {}

	public static synchronized Kino4uaHandler getInstance() {
		if(instance == null) {
			instance = new Kino4uaHandler();
		}
		return instance;
	}

	@Override
	public ProductData handle(Document document) throws IOException {
		String source = document.getElementsByClass("player-box visible full-text")
				.stream().map(Element::children).flatMap(Collection::stream)
				.map(element -> element.attr("src")).findFirst().orElse(null);
		if(source != null) {
			LOGGER.info("The html source for " + source + " video is parsed successfully.");
		} else {
			LOGGER.warn("The html source of current url is not parsed.");
			return null;
		}
		source = !source.contains("https:") ? "https:" + source : source;
		Document subDocument = UrlLoader.getInstance().load(new URL(source));
		return segmentedPlaylistHandler.handle(subDocument);
	}
}
