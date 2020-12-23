package org.jtube;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.lindstrom.m3u8.model.MasterPlaylist;
import io.lindstrom.m3u8.model.MediaPlaylist;
import io.lindstrom.m3u8.parser.AbstractPlaylistParser;
import io.lindstrom.m3u8.parser.MasterPlaylistParser;
import io.lindstrom.m3u8.parser.MediaPlaylistParser;
import io.lindstrom.m3u8.parser.PlaylistParserException;
import org.jtube.data.objectMappers.SegmentedPlaylistSourceDataMapper;
import org.jtube.data.objectMappers.YouTubeSourceDataMapper;
import org.jtube.data.result.ProductData;
import org.jtube.data.segmentedPlaylist.SegmentedPlaylistSourceData;
import org.jtube.data.youtube.YouTubeSourceData;
import org.jtube.data.youtube.Format;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jtube.data.MultimediaFormatType;
import org.jtube.transformators.SegmentedPlaylistTransformator;
import org.jtube.utils.html.SegmentedPlaylistSourceDataFilter;
import org.jtube.utils.html.SourceDataFilter;
import org.jtube.utils.html.YoutubeSourceDataFilter;
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

		try {
			Document document = UrlLoader.getInstance().load(new URL("https://tortuga.wtf/vod/40376"));
			SourceDataFilter filter = SegmentedPlaylistSourceDataFilter.getInstance();
			String masterPlaylistUrl = filter.filterSourceData(document);
			SegmentedPlaylistSourceData sourceData = SegmentedPlaylistSourceDataMapper.getInstance().parseSourceData(masterPlaylistUrl);
			SegmentedPlaylistTransformator transformator = new SegmentedPlaylistTransformator();
			ProductData productData = transformator.transform(sourceData);
			logger.debug(productData);
		} catch (IOException e) {
			e.printStackTrace();
		}

		AbstractPlaylistParser rootParser = new MasterPlaylistParser();
		AbstractPlaylistParser parser = new MediaPlaylistParser();
		try {
			MasterPlaylist root = (MasterPlaylist) rootParser.readPlaylist("#EXTM3U\n" +
					"#EXT-X-STREAM-INF:RESOLUTION=1920x1080,BANDWIDTH=2128000\n" +
					"./1080/index.m3u8\n" +
					"#EXT-X-STREAM-INF:RESOLUTION=1280x720,BANDWIDTH=1096000\n" +
					"./720/index.m3u8\n" +
					"#EXT-X-STREAM-INF:RESOLUTION=854x480,BANDWIDTH=714000\n" +
					"./480/index.m3u8");
			System.out.println(root);
			System.out.println(root.variants().get(0).resolution().get().height());
			System.out.println(root.variants().get(0).bandwidth());
			System.out.println(root.variants().get(0).uri());
			MediaPlaylist playlist = (MediaPlaylist) parser.readPlaylist("#EXTM3U\n" +
					"#EXT-X-VERSION:3\n" +
					"#EXT-X-ALLOW-CACHE:YES\n" +
					"#EXT-X-TARGETDURATION:10\n" +
					"#EXT-X-MEDIA-SEQUENCE:1\n" +
					"#EXT-X-PLAYLIST-TYPE:VOD\n" +
					"#EXTINF:6.256667,\n" +
					"segment1.ts\n" +
					"#EXTINF:5.005333,\n" +
					"segment2.ts\n" +
					"#EXTINF:7.591422,\n" +
					"segment3.ts\n" +
					"#EXT-X-ENDLIST");
			System.out.println(playlist.mediaSegments().get(0).uri());
			System.out.println(playlist);
		} catch (PlaylistParserException e) {
			e.printStackTrace();
		}

	}

	public void downloadBestQuality() {
		logger.info("Processing " + youTubeUrl + " url...");
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
	}

}
