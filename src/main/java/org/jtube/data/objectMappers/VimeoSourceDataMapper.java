package org.jtube.data.objectMappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.jtube.data.SourceDataMapper;
import org.jtube.data.vimeo.VimeoSourceData;
import org.jtube.data.vimeo.playerData.PlayerData;
import org.jtube.data.vimeo.streams.Streams;
import org.jtube.utils.net.UrlLoader;

import java.io.IOException;

public class VimeoSourceDataMapper implements SourceDataMapper {

	private static final Logger LOGGER = Logger.getLogger(VimeoSourceDataMapper.class);
	private static VimeoSourceDataMapper instance;
	private static ObjectMapper objectMapper;

	private VimeoSourceDataMapper() {}

	public static synchronized VimeoSourceDataMapper getInstance() {
		if(instance == null) {
			instance = new VimeoSourceDataMapper();
		}
		if(objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return instance;
	}

	@Override
	public VimeoSourceData parseSourceData(String playerData) throws IOException {
		if(playerData == null) {return null;}
		VimeoSourceData result = new VimeoSourceData();
		//LOGGER.debug(new JSONObject(playerData).toString(3));
		PlayerData playerDataObject = objectMapper.readValue(playerData, PlayerData.class);
		if(playerDataObject != null) {
			LOGGER.info("The stream's locations of " + playerDataObject.getVideo().getUrl() + " id i.e. \""
					+ playerDataObject.getVideo().getTitle() + "\" video are parsed successfully.");
			result.setPlayerData(playerDataObject);
		} else {
			LOGGER.warn("The stream's locations of current url are not parsed.");
			return null;
		}
		String streamsPlaylists = UrlLoader.getInstance()
				.download(playerDataObject.getRequest().getFiles().getDash().defaultCdnObject().getUrl());
		if(streamsPlaylists == null) {return null;}
		Streams streamsPlaylistsObject = objectMapper.readValue(streamsPlaylists, Streams.class);
		if(streamsPlaylistsObject != null) {
			LOGGER.info("The playlists of streams locations of " + playerDataObject.getVideo().getUrl() + " id i.e. \""
					+ playerDataObject.getVideo().getTitle() + "\" video are parsed successfully.");
			result.setStreams(streamsPlaylistsObject);
		} else {
			LOGGER.warn("The playlists of streams locations of current url are not parsed.");
			return null;
		}
		return result;
	}

}
