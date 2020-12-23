package org.jtube.data.objectMappers;

import io.lindstrom.m3u8.model.MasterPlaylist;
import io.lindstrom.m3u8.model.MediaPlaylist;
import io.lindstrom.m3u8.parser.AbstractPlaylistParser;
import io.lindstrom.m3u8.parser.MasterPlaylistParser;
import io.lindstrom.m3u8.parser.MediaPlaylistParser;
import org.apache.log4j.Logger;
import org.jtube.data.SourceDataMapper;
import org.jtube.data.segmentedPlaylist.SegmentedPlaylistSourceData;
import org.jtube.utils.net.UrlLoader;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;

public class SegmentedPlaylistSourceDataMapper implements SourceDataMapper {

	final static Logger logger = Logger.getLogger(SegmentedPlaylistSourceDataMapper.class);
	private static SegmentedPlaylistSourceDataMapper instance;
	private static AbstractPlaylistParser masterPlaylistParser;
	private static AbstractPlaylistParser mediaPlaylistParser;
	private static final UrlLoader URL_LOADER = UrlLoader.getInstance();

	private SegmentedPlaylistSourceDataMapper() {}

	public static synchronized SegmentedPlaylistSourceDataMapper getInstance() {
		if(instance == null) {
			instance = new SegmentedPlaylistSourceDataMapper();
		}
		if(masterPlaylistParser == null) {
			masterPlaylistParser = new MasterPlaylistParser();
		}
		if(mediaPlaylistParser == null) {
			mediaPlaylistParser = new MediaPlaylistParser();
		}
		return instance;
	}

	@Override
	public SegmentedPlaylistSourceData parseSourceData(String masterPlaylistUrl) throws IOException {
		SegmentedPlaylistSourceData result = new SegmentedPlaylistSourceData();
		URL masterPlaylistURL = new URL(masterPlaylistUrl);
		MasterPlaylist masterPlaylist = (MasterPlaylist) masterPlaylistParser.readPlaylist(URL_LOADER.download(masterPlaylistURL));
		result.getUriMasterPlaylistMap().put(masterPlaylistURL, masterPlaylist);
		Map<URL, MediaPlaylist> uriMediaPlaylistMap = result.getUriMediaPlaylistMap();
		masterPlaylist.variants().stream().forEach(variant -> {
			try {
				URL mediaPlaylistURL = new URL(masterPlaylistURL.getProtocol(), masterPlaylistURL.getHost(), masterPlaylistURL.getPort()
						, Paths.get(masterPlaylistURL.getFile()).getParent().toString() + variant.uri().replaceFirst("[\\.]", ""));
				uriMediaPlaylistMap.put(mediaPlaylistURL
						, (MediaPlaylist) mediaPlaylistParser.readPlaylist(URL_LOADER.download(mediaPlaylistURL)));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
		return result;
	}

}
