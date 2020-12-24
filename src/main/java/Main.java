import org.apache.log4j.Logger;
import org.jtube.Processor;
import org.jtube.data.result.ProductData;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

	final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		if(args == null || args.length == 0) {
			System.out.println("Usage: java Example https://www.youtube.com/watch?v=H9154xIoYTA https://ashdi.vip/vod/666 https://tortuga.wtf/vod/40376");
		} else {
			List<ProductData> productDataList = Stream.of(args).map((arg) -> {
				try {
					return new Processor(arg);
				} catch(MalformedURLException e) {
					logger.error(e);
					return null;
				}
			}).filter(Objects::nonNull).map((processor) -> {
				processor.process();
				return processor.getProductData();
			}).collect(Collectors.toList());
			logger.info(productDataList);
		}
	}

	/*public void downloadBestQuality() {
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
