package org.jtube;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jtube.data.objectMappers.InitialPlayerResponseMapper;
import org.jtube.data.ytInitialPlayerResponse.Data;
import org.jtube.data.ytInitialPlayerResponse.MediaFormat;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jtube.data.ytInitialPlayerResponse.MediaFormatType;
import org.jtube.utils.html.Filter;
import org.jtube.utils.media.Merger;
import org.jtube.utils.net.UrlLoader;

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
		Document document;
		try {
			document = UrlLoader.getInstance().load(new URL(youTubeUrl));
		} catch (IOException e) {
			logger.error(e);
			return;
		}
		Data data;
		try {
			data = InitialPlayerResponseMapper.getInstance()
					.parseInitialPlayerResponse(Filter.getInstance().getInitialPlayerResponse(document));
		} catch (JsonProcessingException e) {
			logger.error(e);
			return;
		}
		List<MediaFormat> videoFormats = data.getStreamingData().getFormats(MediaFormatType.VIDEO);
		List<MediaFormat> audioFormats = data.getStreamingData().getFormats(MediaFormatType.AUDIO);
		String title = data.getVideoDetails().getNormalizedTitle();
		logger.info("Going to download " + videoFormats.get(0) + " video and " + audioFormats.get(0)
				+ " audio from " + youTubeUrl + " url.");
		try {
			UrlLoader.getInstance().downloadToFile(videoFormats.get(0).getUrl(), videoFormats.get(0).getTemporaryFile(title));
			UrlLoader.getInstance().downloadToFile(audioFormats.get(0).getUrl(), audioFormats.get(0).getTemporaryFile(title));
		} catch (IOException e) {
			logger.error(e);
			return;
		}
		try {
			Merger.getInstance().mergeAudioAndVideo(audioFormats.get(0).getTemporaryFile(title)
					, videoFormats.get(0).getTemporaryFile(title)
					, videoFormats.get(0).getMergedFile(title));
		} catch (IOException | InterruptedException e) {
			logger.error(e);
			return;
		}
		logger.info("The " + videoFormats.get(0).getTemporaryFile(title).getName() + " temporary video file is deleted: "
				+ videoFormats.get(0).getTemporaryFile(title).delete());
		logger.info("The " + audioFormats.get(0).getTemporaryFile(title).getName() + " temporary audio file is deleted: "
				+ audioFormats.get(0).getTemporaryFile(title).delete());
	}
}
