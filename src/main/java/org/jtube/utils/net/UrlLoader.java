package org.jtube.utils.net;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class UrlLoader {

	final static Logger logger = Logger.getLogger(UrlLoader.class);
	private static UrlLoader instance;

	private UrlLoader() {}

	public static synchronized UrlLoader getInstance() {
		if(instance == null) {
			instance = new UrlLoader();
		}
		return instance;
	}

	public Document load(URL url) throws IOException {
		Document document = Jsoup.parse(url, 3000);
		if(document != null) {
			logger.info("The html source of " + url + " url is downloaded successfully.");
		} else {
			logger.warn("The html source of " + url + " url is not downloaded.");
		}
		return document;
	}

	public String download(URL url) throws IOException {
		String result = null;
		try(InputStream in = url.openStream();
			ReadableByteChannel rbc = Channels.newChannel(in))
		{
			Scanner scanner = new Scanner(rbc);
			result = scanner.useDelimiter("\\z").next();
		}
		if(result == null) {
			logger.warn("The " + url + " url is not downloaded.");
			return null;
		}
		logger.info("The " + url + " url downloaded successfully.");
		return result;
	}

	public File downloadToFile(URL url, File downloadingFile) throws IOException {
		try(InputStream in = url.openStream();
			ReadableByteChannel rbc = Channels.newChannel(in);
			FileOutputStream fos = new FileOutputStream(downloadingFile))
		{
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		}
		if(!downloadingFile.exists()) {
			logger.warn("The " + downloadingFile.getName() + " file is not downloaded.");
			return null;
		}
		logger.info("The " + downloadingFile.getName() + " file downloaded successfully.");
		return downloadingFile;
	}

}
