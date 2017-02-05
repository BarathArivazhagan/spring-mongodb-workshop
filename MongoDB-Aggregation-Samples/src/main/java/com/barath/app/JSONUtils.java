package com.barath.app;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
	
	private static final Logger logger=LoggerFactory.getLogger(JSONUtils.class);
	private static final ObjectMapper mapper=new ObjectMapper();
	
	
	public static String toJson(Object obj){
		String output=null;
		
		try {
			if(obj !=null){
				output=mapper.writeValueAsString(obj);
				if(logger.isInfoEnabled()){
					logger.info("FROM OBJECT  "+obj+" TO JSON "+output);
				}
			}
		} catch (JsonProcessingException e) {
			logger.error("ERROR IN TO JSON "+e.getMessage());
			e.printStackTrace();
		}
		
		 
		
		return output;
	}
	
	public static Object fromJson(String json,Class<?> clazz){
		
		Object obj=null;
		try {
			if(!StringUtils.isEmpty(json) && clazz !=null){
				obj=mapper.readValue(json, clazz);
				if(logger.isInfoEnabled()){
					logger.info("FROM JSON  "+json+" TO OBJECT "+obj.toString());
				}
			}
		} catch (IOException e) {
			logger.error("ERROR IN FROM JSON "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> toMap(Object obj){
		Map<String,Object> output=null;
		if(obj !=null){			
			output=mapper.convertValue(obj, Map.class);	
			if(logger.isInfoEnabled()){
				logger.info(" Converting Obj "+obj.toString()+" to Map "+output);
			}
		}
		return output;
		
	}

}
