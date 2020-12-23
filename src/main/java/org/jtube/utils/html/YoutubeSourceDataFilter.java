package org.jtube.utils.html;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;

public class YoutubeSourceDataFilter implements SourceDataFilter {

	final static Logger logger = Logger.getLogger(YoutubeSourceDataFilter.class);

	private static YoutubeSourceDataFilter instance;

	private YoutubeSourceDataFilter() {}

	public static synchronized YoutubeSourceDataFilter getInstance() {
		if(instance == null) {
			instance = new YoutubeSourceDataFilter();
		}
		return instance;
	}

	@Override
	public String filterSourceData(Document document) {
		String result = document.select("script").stream()
				.filter((element) -> element.data().matches("^var[ ]?ytInitialPlayerResponse[ ]?=[ ]?.*"))
				.findFirst().map((element) -> element.data()
					.replaceAll("^var[ ]?ytInitialPlayerResponse[ ]?=[ ]?\\{\"", "{\"")
					.replaceAll(";var[ ]?.*", "")).orElse(null);
		if(result != null) {
			String url = document.select("link").stream()
					.map((element) -> element.getElementsByAttributeValue("rel", "canonical"))
					.flatMap(elements -> elements.stream())
					.findFirst().map((element) -> element.attr("href"))
					.filter(s -> !s.trim().isEmpty()).orElse("current");
			String title = document.select("meta").stream()
					.map((element) -> element.getElementsByAttributeValue("name", "title"))
					.flatMap(elements -> elements.stream())
					.findFirst().map((element) -> element.attr("content"))
					.filter(s -> !s.trim().isEmpty()).orElse("unknown");
			logger.info("The html source of " + url + " url i.e. \"" + title + "\" video is parsed successfully.");
		} else {
			logger.warn("The html source of current url is not parsed.");
		}
		return result;
	}

}
