import org.apache.log4j.Logger;
import org.jtube.Processor;
import org.jtube.data.result.ProductData;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		if(args == null || args.length == 0) {
			System.out.println("Usage: java Example https://www.youtube.com/watch?v=H9154xIoYTA https://ashdi.vip/vod/666 https://tortuga.wtf/vod/40376");
		} else {
			Stream.of(args).map((arg) -> {
				try {
					return new Processor(arg);
				} catch(MalformedURLException e) {
					LOGGER.error(e + " for " + arg + " url.");
					return null;
				}
			}).filter(Objects::nonNull).peek(Thread::start).peek((processor) -> {
				while(!processor.isFinished()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						LOGGER.error(e + " during waiting for result of " + processor.getUrl() + " url processing.");
					}
				}
			}).forEach(processor -> System.out.println(processor.getProductData()));
		}
	}

	/*public static void downloadBestQuality() {
		/*logger.info("Processing " + youTubeUrl + " url...");
		Document document;
		try {
			document = UrlLoader.getInstance().load(new URL(youTubeUrl));
		} catch (IOException e) {
			logger.error(e);
			return;
		}
		YouTubeSourceData youTubeSourceData;
		try {
			youTubeSourceData = YouTubeSourceDataMapper.getInstance()
					.parseSourceData(YoutubeSourceDataFilter.getInstance().filterSourceData(document));
		} catch (JsonProcessingException e) {
			logger.error(e);
			return;
		}
		List<Format> videoFormats = youTubeSourceData.getStreamingData().getFormats(MultimediaFormatType.VIDEO);
		List<Format> audioFormats = youTubeSourceData.getStreamingData().getFormats(MultimediaFormatType.AUDIO);
		String title = youTubeSourceData.getVideoDetails().getNormalizedTitle();
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
	}*/
}
