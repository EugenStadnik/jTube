import org.apache.log4j.Logger;
import org.jtube.Processor;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.utils.Constants;
import org.jtube.utils.net.UrlLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) {
		List<ProductData> productData = new ArrayList<>();
		if(args == null || args.length == 0) {
			System.out.println("Usage: java Example https://www.youtube.com/watch?v=H9154xIoYTA https://ashdi.vip/vod/666 https://tortuga.wtf/vod/40376");
		} else {
			productData = Stream.of(args).parallel().map((arg) -> {
				try {
					return new Processor(arg);
				} catch(MalformedURLException e) {
					LOGGER.error(e + " for " + arg + " url.");
					return null;
				}
			}).filter(Objects::nonNull).peek(Thread::start).peek((processor) -> {
				try {
					synchronized(Thread.currentThread()) {
						while(!processor.isFinished()) {
							Thread.currentThread().wait(1000);
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).map(Processor::getProductData).collect(Collectors.toList());
		}
		LOGGER.info("There is/are " + productData.size() + " processed result(s).");
		//downloadBestQuality(productData);
	}

	public static void downloadBestQuality(List<ProductData> productData) {
		productData.stream().filter(productData1 -> productData1.getErrors().isEmpty()).forEach(
				(productData1) -> {
					List<MultiMediaStream> audioVideoStreams = productData1.getMultiMediaStreams(MultimediaFormatType.AUDIO_VIDEO);
					List<MultiMediaStream> videoStreams = productData1.getMultiMediaStreams(MultimediaFormatType.VIDEO);
					List<MultiMediaStream> audioStreams = productData1.getMultiMediaStreams(MultimediaFormatType.AUDIO);
					Collections.sort(audioVideoStreams);
					Collections.sort(videoStreams);
					Collections.sort(audioStreams);
					try {
						UrlLoader.getInstance().downloadToFile(audioVideoStreams.get(0).getUrls()
								, new File(Constants.TMP + productData1.getTitle() + ".ts"));
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
		);
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
