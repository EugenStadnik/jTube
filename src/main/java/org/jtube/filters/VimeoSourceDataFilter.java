package org.jtube.filters;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jtube.utils.net.UrlLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class VimeoSourceDataFilter implements SourceDataFilter {

	private static final Logger LOGGER = Logger.getLogger(VimeoSourceDataFilter.class);

	private static VimeoSourceDataFilter instance;

	private VimeoSourceDataFilter() {}

	public static synchronized VimeoSourceDataFilter getInstance() {
		if(instance == null) {
			instance = new VimeoSourceDataFilter();
		}
		return instance;
	}

	@Override
	public String filterSourceData(Document document) {
		Document playerDataDocument;
		Elements ogVideoUrl = document.getElementsByAttributeValue("property", "og:video:url");
		Elements twitterPlayer = document.getElementsByAttributeValue("name", "twitter:player");
		Elements playerUrlTag = ogVideoUrl != null && !ogVideoUrl.isEmpty() ? ogVideoUrl
				: twitterPlayer != null && !twitterPlayer.isEmpty() ? twitterPlayer : null;
		if(playerUrlTag == null) {
			LOGGER.warn("The html source of current url is not parsed. Unable to parse url like \"https://player.vimeo.com/video/1234\" format.");
			return null;
		}
		try {
			playerDataDocument = UrlLoader.getInstance().load(new URL(Objects.requireNonNull(playerUrlTag.stream()
					.findFirst().map(element -> element.attr("content")).orElse(null))));
		} catch (IOException e) {
			LOGGER.warn("The html source of current url is not parsed. The reason is: " + e);
			return null;
		}
		if(playerDataDocument == null) {
			LOGGER.warn("The html source of current url is not parsed. It is unable to download Player Data.");
			return null;
		}
		String result = playerDataDocument.select("script").stream()
				.filter((element) -> element.data().matches("^[ ]?\\([ ]?function[ ]?\\([ ]?document,[ ]?player[ ]?\\)[ ]?\\{[ ]?var config[ ]?=[ ]?\\{.*"))
				.findFirst().map((element) -> element.data()
						.replaceFirst("^[ ]?\\([ ]?function[ ]?\\([ ]?document,[ ]?player[ ]?\\)[ ]?\\{[ ]?var config[ ]?=[ ]?\\{", "{")
						.replaceAll(";[ ]?if[ ]?\\([ ]?!config.request[ ]?\\)[ ]?\\{[ ]?return;[ ]?.*", "")).orElse(null);
		if(result != null) {
			LOGGER.info("The html source for current url is parsed successfully.");
		} else {
			LOGGER.warn("The html source of current url is not parsed.");
		}
		return result;
	}

}
