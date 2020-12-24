package org.jtube;

import org.jtube.data.result.ProductData;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jtube.handlers.Handler;
import org.jtube.handlers.SegmentedPlaylistHandler;
import org.jtube.handlers.YouTubeHandler;
import org.jtube.utils.net.UrlLoader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.stream.Stream;

public class Processor {

	final static Logger logger = Logger.getLogger(Processor.class);

	private final Stream<Handler> handlersStream = Stream.of(new YouTubeHandler(), new SegmentedPlaylistHandler());
	private final URL url;
	private ProductData productData;

	public Processor(String url) throws MalformedURLException {
		this.url = new URL(url);
	}

	public Processor(URL url) {
		this.url = url;
	}

	public void process() {
		try {
			Document document = UrlLoader.getInstance().load(url);
			productData = handlersStream.map(handler -> {
				logger.debug(handler.getClass().getSimpleName() + " handler is working for " + url + " url...");
				try {
					ProductData productData = handler.handle(document);
					if(productData == null) {
						return null;
					}
					productData.setCanonicalUrl(url);
					return productData;
				} catch (Exception e) {
					logger.warn("" + e + " for " + url + " url.");
					return null;
				}

			}).filter(Objects::nonNull).findFirst().orElse(null);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public ProductData getProductData() {
		return productData;
	}

}
