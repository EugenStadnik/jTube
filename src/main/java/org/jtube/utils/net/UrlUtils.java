package org.jtube.utils.net;

import org.apache.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;

public class UrlUtils {

	private static final Logger LOGGER = Logger.getLogger(UrlUtils.class);
	private static UrlUtils instance;

	private UrlUtils() {}

	public static synchronized UrlUtils getInstance() {
		if(instance == null) {
			instance = new UrlUtils();
		}
		return instance;
	}

	public String masterPlaylistUrlToTitle(URL url) {
		return Arrays.stream(url.getFile()
				.replace("/index.m3u8", "")
				.replace("/hls", "")
				.split("/"))
				.reduce((s, s2) -> s2).orElse("unknownTitle");
	}

	public URL enrichUrl(URL masterPlaylistURL, String suffix) {
		try {
			return new URL(masterPlaylistURL.getProtocol(), masterPlaylistURL.getHost(), masterPlaylistURL.getPort()
					, Paths.get(masterPlaylistURL.getFile()).getParent().toString() + suffix.replaceFirst("^[.]", ""));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

}
