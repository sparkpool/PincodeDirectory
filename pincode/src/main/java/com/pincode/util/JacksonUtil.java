package com.pincode.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonUtil {

	private static final Logger logger = Logger.getLogger(JacksonUtil.class);
			
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String getResponseAsString(Object object){
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error(e);
		} catch (JsonMappingException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return "{}";
	}
	
}
