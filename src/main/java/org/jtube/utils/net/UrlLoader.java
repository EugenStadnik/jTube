package org.jtube.utils.net;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.utils.Constants;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

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

	public File downloadToFile(String initSegmentBase64, List<URL> urls, File downloadingFile) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(downloadingFile)));
		if(initSegmentBase64 != null && !initSegmentBase64.isEmpty() && !initSegmentBase64.isBlank()) {
			byte[] unbased = Base64.getDecoder().decode(initSegmentBase64);
			out.write(unbased);
		}
		urls.forEach((url) -> {
			LOGGER.info("Processing " + url + " url...");
			InputStream in;
			boolean downloaded = false;
			int attempt = 1;
			while(!downloaded) {
				try {
					in = url.openStream();
					out.write(in.readAllBytes());
					in.close();
					downloaded = true;
				} catch (IOException e) {
					LOGGER.warn("Unable to process " + url + " url.");
					LOGGER.warn("The reason is " + e + ". Attempt " + ++attempt + "...");
				}
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

	public File downloadToTempFile(MultiMediaStream multiMediaStream) throws IOException {
		return downloadToFile(multiMediaStream.getInitSegmentBase64(), multiMediaStream.getUrls()
				, new File(Constants.TMP + multiMediaStream.parentProductData().getTitle()
						+ "." + multiMediaStream.getFileContainer()));
	}

	public File downloadToFile(MultiMediaStream multiMediaStream, File file) throws IOException {
		return downloadToFile(multiMediaStream.getInitSegmentBase64(), multiMediaStream.getUrls(), file);
	}

}
