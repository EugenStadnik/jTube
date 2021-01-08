import org.apache.log4j.Logger;
import org.jtube.Processor;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.Source;
import org.jtube.data.result.MultiMediaStream;
import org.jtube.data.result.ProductData;
import org.jtube.utils.Constants;
import org.jtube.utils.media.YouTubeMerger;
import org.jtube.utils.net.UrlLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) {
		List<ProductData> productData = new ArrayList<>();
		if (args == null || args.length == 0) {
			System.out.println("Usage: java Example https://www.youtube.com/watch?v=H9154xIoYTA https://ashdi.vip/vod/666 https://tortuga.wtf/vod/40376");
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
			}).map(Processor::getProductData).collect(Collectors.toList());
		}
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
						if (Source.YOUTUBE.equals(productData1.getSource())) {
							downloadBestQualityYouTube(!audioVideoStreams.isEmpty() ? audioVideoStreams.get(0) : null
									, !videoStreams.isEmpty() ? videoStreams.get(0) : null
									, !audioStreams.isEmpty() ? audioStreams.get(0) : null);
						} else if(Source.SEGMENTED_PLAYLIST.equals(productData1.getSource())) {
							UrlLoader.getInstance().downloadToFile(audioVideoStreams.get(0).getUrls()
									, new File(Constants.DOWNLOADED + audioVideoStreams.get(0).parentProductData().getTitle()
											+ "." + audioVideoStreams.get(0).getFileContainer()));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		);
	}

	public static void downloadBestQualityYouTube(MultiMediaStream bestAudioVideoStream
			, MultiMediaStream bestVideoStream
			, MultiMediaStream bestAudioStream) {
		long audioVideoBitrate = Optional.ofNullable(bestAudioVideoStream).map(MultiMediaStream::getBitRate).orElse(0L);
		long videoBitrate = Optional.ofNullable(bestVideoStream).map(MultiMediaStream::getBitRate).orElse(0L);
		long audioBitrate = Optional.ofNullable(bestAudioStream).map(MultiMediaStream::getBitRate).orElse(0L);
		try {
			if(audioVideoBitrate >= videoBitrate + audioBitrate) {
				assert bestAudioVideoStream != null;
				UrlLoader.getInstance().downloadToFile(bestAudioVideoStream.getUrls()
						, new File(Constants.DOWNLOADED + bestAudioVideoStream.parentProductData().getTitle()
								+ "." + bestAudioVideoStream.getFileContainer()));
			} else {
				assert bestVideoStream != null;
				File temporaryVideoFile = UrlLoader.getInstance().downloadToFile(bestVideoStream.getUrls()
						, new File(Constants.TMP + bestVideoStream.parentProductData().getTitle()
								+ bestVideoStream.getType()
								+ "." + bestVideoStream.getFileContainer()));
				assert bestAudioStream != null;
				File temporaryAudioFile = UrlLoader.getInstance().downloadToFile(bestAudioStream.getUrls()
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
