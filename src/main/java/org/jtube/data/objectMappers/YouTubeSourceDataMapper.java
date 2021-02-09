package org.jtube.data.objectMappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.jtube.data.SourceDataMapper;
import org.jtube.data.youtube.YouTubeSourceData;

public class YouTubeSourceDataMapper implements SourceDataMapper {

	private static final Logger LOGGER = Logger.getLogger(YouTubeSourceDataMapper.class);
	private static YouTubeSourceDataMapper instance;
	private static ObjectMapper objectMapper;

	private YouTubeSourceDataMapper() {}

	public static synchronized YouTubeSourceDataMapper getInstance() {
		if(instance == null) {
			instance = new YouTubeSourceDataMapper();
		}
		if(objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return instance;
	}

	@Override
	public YouTubeSourceData parseSourceData(String initialPlayerResponse) throws JsonProcessingException {
		if(initialPlayerResponse == null) {return null;}
		YouTubeSourceData youTubeSourceData = objectMapper.readValue(initialPlayerResponse, YouTubeSourceData.class);
		if(youTubeSourceData != null) {
			LOGGER.info("The media locations of " + youTubeSourceData.getVideoDetails().getVideoId() + " id i.e. \""
					+ youTubeSourceData.getVideoDetails().getTitle() + "\" video are parsed successfully.");
		} else {
			LOGGER.warn("The media locations of current url are not parsed.");
			return null;
		}
		return youTubeSourceData;
	}

}
