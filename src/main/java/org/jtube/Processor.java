package org.jtube;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jtube.data.result.ProductData;
import org.jtube.handlers.Handler;
import org.jtube.handlers.VimeoHandler;
import org.jtube.handlers.YouTubeHandler;
import org.jtube.handlers.segmentedPlaylist.EneyidaHandler;
import org.jtube.handlers.segmentedPlaylist.Kino4uaHandler;
import org.jtube.handlers.segmentedPlaylist.KinoTronHandler;
import org.jtube.handlers.segmentedPlaylist.SegmentedPlaylistHandler;
import org.jtube.utils.net.UrlLoader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.stream.Stream;

public class Processor extends Thread {

	private static final Logger LOGGER = Logger.getLogger(Processor.class);
	private final URL url;
	private final Stream<Handler> handlersStream = Stream.of(YouTubeHandler.getInstance(), VimeoHandler.getInstance()
			, EneyidaHandler.getInstance(), KinoTronHandler.getInstance(), Kino4uaHandler.getInstance()
			, SegmentedPlaylistHandler.getInstance());
	private ProductData productData;
	private boolean finished = false;

	public Processor(String url) throws MalformedURLException {
		this.url = new URL(url);
	}
	public Processor(URL url) {
		this.url = url;
	}

	public URL getUrl() {
		return url;
	}

	public boolean isFinished() {
		return finished;
	}

	public ProductData getProductData() {
		return productData;
	}

	@Override
	public void run() {
		try {
			Document document = UrlLoader.getInstance().load(url);
			this.productData = handlersStream.map(handler -> {
				LOGGER.debug(handler.getClass().getSimpleName() + " handler is working for " + url + " url...");
				try {
					ProductData productData = handler.handle(document);
					if(productData == null) {
						return null;
					}
					productData.setCanonicalUrl(url);
					return productData;
				} catch (Exception e) {
					LOGGER.error("" + e + " for " + url + " url.");
					e.printStackTrace();
					return new ProductData().withCanonicalUrl(url).withAppendError(e);
				}
			}).filter(Objects::nonNull).findFirst().orElse(
					new ProductData().withCanonicalUrl(url).withAppendError(
							new NoSuchAlgorithmException("Unable to process " + url + " - no appropriate handler is implemented.")
					)
			);
		} catch (IOException e) {
			LOGGER.error("" + e + " for " + url + " url.");
			if(this.productData == null) {
				this.productData = new ProductData().withCanonicalUrl(url).withAppendError(e);
			} else {
				this.productData.withAppendError(e);
			}
		}
		this.finished = true;
		synchronized(this) {
			this.notify();
		}
	}

}
