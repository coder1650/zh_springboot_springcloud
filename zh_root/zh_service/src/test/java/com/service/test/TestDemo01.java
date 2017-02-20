package com.service.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.model.entity.ResultInfo;
import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.util.JsonUtil;

public class TestDemo01 {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void test01() throws JsonParseException, JsonMappingException, IOException{
		String str = "[{\"appId\":\"5000001436\",\"payChannelName\":\"支付宝手机网站支付\",\"payChannelCode\":100103},{\"appId\":\"5000001436\",\"payChannelName\":\"微信手机网站支付\",\"payChannelCode\":100203}]";
		JavaType javaType = getCollectionType(List.class, PayTypeInfo.class);
		 List<PayTypeInfo> configList =  objectMapper.readValue(str, javaType);   //这里不需要强制转换
		 System.out.println(configList);
	}
	
	 public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		    return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	}
	 
	 @Test
	 public void test02() throws Exception{
		 String str = "true";
		 Class.forName("boolean");
		 System.out.println(objectMapper.readValue(str, Boolean.class));
	 }
	 
	 @Test
	 public void test03() throws IOException{
		 String str = "{\"returnCode\":\"100\",\"httpStatus\":200,\"msg\":null,\"url\":null,\"data\":\"TEST32201701121728112141754\"}";
		 ResultInfo r = JsonUtil.convertStringToObject(str, ResultInfo.class);
		 System.out.println(r.getData());
	 }

}
