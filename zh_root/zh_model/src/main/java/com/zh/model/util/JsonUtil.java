package com.zh.model.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
	

	
	public static String getString(Object obj) throws JsonProcessingException{
		return objectMapper.writeValueAsString(obj);
	}
	
	public static <T> T convertStringToObject(String source,Class<T> t) throws IOException{
//		JavaType javaType = getCollectionType(ArrayList.class, T.class); 
		return objectMapper.readValue(source, t);
	}
	
	public static <T> T convertStringToObject(String source,JavaType javaType) throws Exception{
		return objectMapper.readValue(source, javaType);
	}
	
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses){
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);  
	}
	
	

}
