package org.jtube.utils.html;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Arrays;

public class SegmentedPlaylistSourceDataFilter implements SourceDataFilter {

	final static Logger logger = Logger.getLogger(SegmentedPlaylistSourceDataFilter.class);

	private static SegmentedPlaylistSourceDataFilter instance;

	private SegmentedPlaylistSourceDataFilter() {}

	public static synchronized SegmentedPlaylistSourceDataFilter getInstance() {
		if(instance == null) {
			instance = new SegmentedPlaylistSourceDataFilter();
		}
		return instance;
	}

	@Override
	public String filterSourceData(Document document) {
		String result = Arrays.stream(document.getElementsByAttributeValue("type", "text/javascript").stream()
				.filter((element) -> element.data().contains("file:")).findFirst()
				.map(Element::data).orElse("").split("\n"))

				.filter(s -> s.contains("file:")).findFirst()
				.map(s -> s.replaceAll("^\\s+file:[ ]?\"", "").replaceAll("\",$", ""))
				.orElse(null);
		if(result != null) {
			logger.info("The html source for " + result + " video is parsed successfully.");
		} else {
			logger.warn("The html source of current url is not parsed.");
		}
		return result;
	}

}
