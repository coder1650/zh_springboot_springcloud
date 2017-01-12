package com.zh.model.util;

import java.io.IOException;
import java.util.List;

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
	
	public static String convertObjectToString(Object o) throws JsonProcessingException{
		return objectMapper.writeValueAsString(o);
	}
	
	public static <T> T convertStringToObject(String source,JavaType javaType) throws Exception{
		return objectMapper.readValue(source, javaType);
	}
	
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses){
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);  
	}
	
	/**
	 * 把字符串转成Object对象
	 * @param source
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	public static Object convertStringToObject(String source,String  typeName) throws Exception{
		if(typeName.contains("java.util.List")){
			int beginIndex = typeName.indexOf("<");
			int endIndex = typeName.indexOf(">");
			String className = typeName.substring(beginIndex+1, endIndex);
			Class<?> c = Class.forName(className);
			JavaType javaType = getCollectionType(List.class, c);
			return convertStringToObject(source, javaType);
		}else if(typeName.equals("boolean")){
			return convertStringToObject(source,Boolean.class);
		}
		else{
			return convertStringToObject(source, Class.forName(typeName));
		}
	}
	
	

}
