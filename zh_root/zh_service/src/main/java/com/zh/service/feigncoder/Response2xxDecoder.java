package com.zh.service.feigncoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.JavaType;
import com.zh.model.constant.ReturnCode;
import com.zh.model.customException.GlobalException;
import com.zh.model.entity.ResultInfo;
import com.zh.model.util.JsonUtil;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.StringDecoder;

@Configuration
public class Response2xxDecoder extends StringDecoder {
	private static final Logger logger = LoggerFactory.getLogger(Response2xxDecoder.class);
	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		if (response.status() == 404){
			logger.error("response status is 404");
			return Util.emptyValueOf(type);
		}
			
		if (response.body() == null){
			logger.error("response body is null");
			return null;
		}
			
		if (byte[].class.equals(type)) {
			logger.info("type is byte[]");
			return Util.toByteArray(response.body().asInputStream());
		}
		String result = Util.toString(response.body().asReader());
		ResultInfo resultInfo = null;
		try {
			resultInfo = JsonUtil.convertStringToObject(result, ResultInfo.class);
		} catch (Exception e) {
			//如果转换异常，则说明返回值不是json支付串，就直接返回。
			logger.info("request remote service return is not json string,direct this result:"+result);
			return result;
		}
		
		if (ReturnCode.SERVICE_OK.equals(resultInfo.getReturnCode())) {
			String str = JsonUtil.getString(resultInfo.getData());
			logger.info("request remote service return is ok,return data is:"+str);
			try {
				String typeName = type.getTypeName();
				return convertStringToObject(str, typeName);
			} catch (Exception e) {
				String msg = "bind data to controller return value error:"+e.getCause().getMessage();
				GlobalException globalException = new GlobalException(msg);
				globalException.setResultInfo(resultInfo);
				logger.error(msg);
				throw globalException;
			}
		} else {
			logger.error("request remote service return is error,return data is:"+resultInfo.getMsg());
			GlobalException globalException = new GlobalException(resultInfo.getMsg());
			globalException.setResultInfo(resultInfo);
			throw globalException;
		}

	}
	
	
	private Object convertStringToObject(String source,String  typeName) throws Exception{
		if(typeName.contains("java.util.List")){
			int beginIndex = typeName.indexOf("<");
			int endIndex = typeName.indexOf(">");
			String className = typeName.substring(beginIndex+1, endIndex);
			Class<?> c = Class.forName(className);
			JavaType javaType = JsonUtil.getCollectionType(List.class, c);
			return JsonUtil.convertStringToObject(source, javaType);
		}else{
			return JsonUtil.convertStringToObject(source, Class.forName(typeName));
		}
	}

}
