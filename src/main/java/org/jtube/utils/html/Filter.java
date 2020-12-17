package org.jtube.utils.html;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;

public class Filter {

	final static Logger logger = Logger.getLogger(Filter.class);

	private static Filter instance;

	private Filter() {}

	public static synchronized Filter getInstance() {
		if(instance == null) {
			instance = new Filter();
		}
		return instance;
	}

	public String getInitialPlayerResponse(Document document) {
		String result = document.select("script").stream()
				.filter((element) -> element.data().matches("^var[ ]?ytInitialPlayerResponse[ ]?=[ ]?.*"))
				.findFirst().map((element) -> element.data()
					.replaceAll("^var[ ]?ytInitialPlayerResponse[ ]?=[ ]?\\{\"", "{\"")
					.replaceAll(";var[ ]?.*", "")).orElse(null);
		if(result != null) {
			logger.info("The html source of current url is parsed successfully.");
		} else {
			logger.warn("The html source of current url is not parsed.");
		}
		return result;
	}

}
