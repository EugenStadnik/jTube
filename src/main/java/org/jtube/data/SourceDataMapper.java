package org.jtube.data;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface SourceDataMapper {

	SourceData parseSourceData(String sourceData) throws IOException;

}
