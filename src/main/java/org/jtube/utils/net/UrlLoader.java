package org.jtube.utils.net;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jtube.data.result.MultiMediaStream;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UrlLoader {

	private static final Logger LOGGER = Logger.getLogger(UrlLoader.class);
	private static UrlLoader instance;

	private UrlLoader() {}

	public static synchronized UrlLoader getInstance() {
		if(instance == null) {
			instance = new UrlLoader();
		}
		return instance;
	}

	public Document load(URL url) throws IOException {
		Document document = Jsoup.parse(url, 10000);
		if(document != null) {
			LOGGER.info("The html source of " + url + " url is downloaded successfully.");
		} else {
			LOGGER.warn("The html source of " + url + " url is not downloaded.");
		}
		return document;
	}

	public String download(URL url) throws IOException {
		String result;
		try(InputStream in = url.openStream();
			ReadableByteChannel rbc = Channels.newChannel(in))
		{
			Scanner scanner = new Scanner(rbc);
			result = scanner.useDelimiter("\\A").next();
		}
		if(result == null) {
			LOGGER.warn("The " + url + " url is not downloaded.");
			return null;
		}
		LOGGER.info("The " + url + " url downloaded successfully.");
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
			LOGGER.warn("The " + downloadingFile.getName() + " file is not downloaded.");
			return null;
		}
		LOGGER.info("The " + downloadingFile.getName() + " file downloaded successfully.");
		return downloadingFile;
	}

	public File downloadToFile(List<URL> urls, File downloadingFile) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(downloadingFile)));
		urls.forEach((url) -> {
			LOGGER.info("Processing " + url + " url...");
			InputStream in;
			try {
				in = url.openStream();
				out.write(in.readAllBytes());
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		out.close();
		if(!downloadingFile.exists()) {
			LOGGER.warn("The " + downloadingFile.getName() + " file is not downloaded.");
			return null;
		}
		LOGGER.info("The " + downloadingFile.getName() + " file downloaded successfully.");
		return downloadingFile;
	}

	public List<File> downloadToFiles(MultiMediaStream multiMediaStream, String title, String path) {
		return Stream.iterate(0, n -> n + 1).limit(multiMediaStream.getUrls().size()).map((index) -> {
			URL url = multiMediaStream.getUrls().get(index);
			try {
				File file = new File(path + title + "_"
						+ multiMediaStream.getType().toString().toLowerCase() + "_segment_" + (index + 1) + ".dat");
				return downloadToFile(url, file);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

}
