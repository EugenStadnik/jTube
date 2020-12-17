package org.jtube.data.objectMappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.jtube.data.ytInitialPlayerResponse.Data;

public class InitialPlayerResponseMapper {

	final static Logger logger = Logger.getLogger(InitialPlayerResponseMapper.class);
	private static InitialPlayerResponseMapper instance;
	private static ObjectMapper objectMapper;

	private InitialPlayerResponseMapper() {}

	public static synchronized InitialPlayerResponseMapper getInstance() {
		if(instance == null) {
			instance = new InitialPlayerResponseMapper();
		}
		if(objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return instance;
	}

	public Data parseInitialPlayerResponse(String initialPlayerResponse) throws JsonProcessingException {
		Data data = objectMapper.readValue(initialPlayerResponse, Data .class);
		if(data != null) {
			logger.info("The media locations of " + data.getVideoDetails().getVideoId() + " video are parsed successfully.");
		} else {
			logger.warn("The media locations of current url are not parsed.");
		}
		return data;
	}

}
