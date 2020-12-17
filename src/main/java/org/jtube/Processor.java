package org.jtube;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jtube.data.objectMappers.InitialPlayerResponseMapper;
import org.jtube.data.ytInitialPlayerResponse.Data;
import org.jtube.data.ytInitialPlayerResponse.MediaFormat;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jtube.data.ytInitialPlayerResponse.MediaFormatType;
import org.jtube.utils.Constants;
import org.jtube.utils.html.Filter;
import org.jtube.utils.media.Merger;
import org.jtube.utils.net.UrlLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Processor extends Thread {

	final static Logger logger = Logger.getLogger(Processor.class);

	private String youTubeUrl;

	public Processor(String youTubeUrl) {
		this.youTubeUrl = youTubeUrl;
	}

	@Override
	public void run() {
		logger.info("Processing " + youTubeUrl + " url...");
		UrlLoader urlLoader = UrlLoader.getInstance();
		Document document;
		try {
			document = urlLoader.load(youTubeUrl);
		} catch (IOException e) {
			logger.error(e);
			return;
		}
		Filter filter = Filter.getInstance();
		String initialPlayerResponse = filter.getInitialPlayerResponse(document);
		InitialPlayerResponseMapper mapper = InitialPlayerResponseMapper.getInstance();
		Data data;
		try {
			data = mapper.parseInitialPlayerResponse(initialPlayerResponse);
		} catch (JsonProcessingException e) {
			logger.error(e);
			return;
		}
		List<MediaFormat> videoFormats = data.getStreamingData().getFormats(MediaFormatType.VIDEO);
		List<MediaFormat> audioFormats = data.getStreamingData().getFormats(MediaFormatType.AUDIO);
		String title = data.getVideoDetails().getNormalizedTitle();
		File tempVideo = new File(Constants.TMP + title + videoFormats.get(0).getFileSufix());
		File tempAudio = new File(Constants.TMP + title + audioFormats.get(0).getFileSufix());
		logger.info("Going to download " + videoFormats.get(0) + " video and " + audioFormats.get(0)
				+ " audio from " + youTubeUrl + " url.");
		try {
			urlLoader.downloadToFile(new URL(videoFormats.get(0).getUrl()), tempVideo);
			urlLoader.downloadToFile(new URL(audioFormats.get(0).getUrl()), tempAudio);
		} catch (IOException e) {
			logger.error(e);
			return;
		}
		File mergedVideo = new File(Constants.DOWNLOADED + title + Constants.AVI);
		try {
			Merger.getInstance().mergeAudioAndVideo(tempAudio, tempVideo, mergedVideo);
		} catch (IOException | InterruptedException e) {
			logger.error(e);
			return;
		}
		logger.info("The " + tempVideo.getName() + " temporary video file is deleted: " + tempVideo.delete());
		logger.info("The " + tempAudio.getName() + " temporary audio file is deleted: " + tempAudio.delete());
	}
}
