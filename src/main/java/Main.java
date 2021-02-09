import org.apache.log4j.Logger;
import org.jtube.Processor;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.utils.Constants;
import org.jtube.utils.media.YouTubeMerger;
import org.jtube.utils.net.UrlLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) throws IOException {
		List<ProductData> productData = new ArrayList<>();
		if (args == null || args.length == 0) {
			System.out.println("Usage: java -jar jTube https://www.youtube.com/watch?v=H9154xIoYTA"
					+ " https://ashdi.vip/vod/666 https://tortuga.wtf/vod/40376 https://vimeo.com/497879805");
		} else {
			productData = Stream.of(args).parallel().map((arg) -> {
				try {
					return new Processor(arg);
				} catch (MalformedURLException e) {
					LOGGER.error(e + " for " + arg + " url.");
					return null;
				}
			}).filter(Objects::nonNull).peek(Thread::start).peek((processor) -> {
				try {
					synchronized(Thread.currentThread()) {
						while (!processor.isFinished()) {
							Thread.currentThread().wait(10);
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).map(Processor::getProductData)
					//.peek(productData1 -> productData1.getMultiMediaStreams().stream().forEach(multiMediaStream -> LOGGER.debug(multiMediaStream.getUrls())))
					.collect(Collectors.toList());
		}
		//LOGGER.debug(productData);
		downloadBestQuality(productData);
		LOGGER.info("To append multiple subtitles and audio tracks use following script: "
				+ "\"ffmpeg -i in_HD_UKR.ts -i in_SD_ENG.ts -i ENG.srt -i UKR.ass"
				+ " -c:v copy -c:a copy -c:s copy -map 0:0 -map 1:1 -map 0:1 -map 2:0 -map 3:0"
				+ " -metadata:s:a:0 title=\"English\" -metadata:s:a:1 title=\"Ukrainian\""
				+ " -metadata:s:a:0 language=eng -metadata:s:a:1 language=ukr"
				+ " -metadata:s:s:0 title=\"English\" -metadata:s:s:1 title=\"Ukrainian\""
				+ " -metadata:s:s:0 language=eng -metadata:s:s:1 language=ukr out.mkv\"");
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
						if (!videoStreams.isEmpty() && !audioStreams.isEmpty()) {
							downloadBestAvailableQuality(!audioVideoStreams.isEmpty() ? audioVideoStreams.get(0) : null
									, videoStreams.get(0)
									, audioStreams.get(0));
						} else if(!audioVideoStreams.isEmpty()) {
							LOGGER.info("Downloading combined audio/video stream for "
									+ productData1.getCanonicalUrl() + " i.e. \"" + productData1.getTitle()
									+ "\" video as only available...");
							UrlLoader.getInstance().downloadToFile(audioVideoStreams.get(0)
									, new File(Constants.DOWNLOADED + audioVideoStreams.get(0).parentProductData().getTitle()
											+ "." + audioVideoStreams.get(0).getFileContainer()));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		);
	}

	public static void downloadBestAvailableQuality(MultiMediaStream bestAudioVideoStream
			, MultiMediaStream bestVideoStream
			, MultiMediaStream bestAudioStream) {
		long audioVideoBitrate = Optional.ofNullable(bestAudioVideoStream).map(MultiMediaStream::getBitRate).orElse(0L);
		long videoBitrate = Optional.ofNullable(bestVideoStream).map(MultiMediaStream::getBitRate).orElse(0L);
		long audioBitrate = Optional.ofNullable(bestAudioStream).map(MultiMediaStream::getBitRate).orElse(0L);
		try {
			if(audioVideoBitrate >= videoBitrate + audioBitrate) {
				assert bestAudioVideoStream != null;
				LOGGER.info("Downloading combined audio/video stream for "
						+ bestAudioVideoStream.parentProductData().getCanonicalUrl() + " i.e. \"" + bestAudioVideoStream.parentProductData().getTitle()
						+ "\" video as better quality of " + bestAudioVideoStream.getResolution() + " and " + bestAudioVideoStream.getBitRate() + "bps ...");
				UrlLoader.getInstance().downloadToFile(bestAudioVideoStream
						, new File(Constants.DOWNLOADED + bestAudioVideoStream.parentProductData().getTitle()
								+ "." + bestAudioVideoStream.getFileContainer()));
			} else {
				assert bestVideoStream != null;
				assert bestAudioStream != null;
				LOGGER.info("Downloading separate audio and video streams for "
						+ bestVideoStream.parentProductData().getCanonicalUrl() + " i.e. \"" + bestVideoStream.parentProductData().getTitle()
						+ "\" video as better quality of " + bestVideoStream.getResolution() + " and " + bestAudioStream.getBitRate() + "bps ...");
				File temporaryVideoFile = UrlLoader.getInstance().downloadToFile(bestVideoStream
						, new File(Constants.TMP + bestVideoStream.parentProductData().getTitle()
								+ bestVideoStream.getType()
								+ "." + bestVideoStream.getFileContainer()));
				File temporaryAudioFile = UrlLoader.getInstance().downloadToFile(bestAudioStream
						, new File(Constants.TMP + bestAudioStream.parentProductData().getTitle()
								+ bestAudioStream.getType()
								+ "." + bestAudioStream.getFileContainer()));
				File outputFile = new File(Constants.DOWNLOADED
						+ bestVideoStream.parentProductData().getTitle() + "." + bestVideoStream.getFileContainer());
				outputFile = YouTubeMerger.getInstance().mergeMultimediaFiles(temporaryAudioFile
						, temporaryVideoFile, outputFile);
				if(outputFile != null) {
					LOGGER.info("The temporary " + temporaryVideoFile.getName() + " file deleted successfully: " + temporaryVideoFile.delete());
					LOGGER.info("The temporary " + temporaryAudioFile.getName() + " file deleted successfully: " + temporaryAudioFile.delete());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
