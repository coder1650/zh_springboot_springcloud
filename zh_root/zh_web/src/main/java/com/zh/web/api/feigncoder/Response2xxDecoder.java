package com.zh.web.api.feigncoder;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.ribbon.ServerError;
import com.zh.model.customException.ErrorInfo;
import com.zh.web.api.exception.ServerException;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.StringDecoder;

//@Configuration
public class Response2xxDecoder extends StringDecoder{
	
	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		if (response.status() == 404) return Util.emptyValueOf(type);
	      if (response.body() == null) return null;
	      if (byte[].class.equals(type)) {
	        return Util.toByteArray(response.body().asInputStream());
	      }
	      String result = Util.toString(response.body().asReader());
//	      ObjectMapper om = new ObjectMapper();
//	      ErrorInfo errorInfo = om.readValue(result, ErrorInfo.class);
//	      if(ErrorInfo.ERROR.equals(errorInfo.getCode())){
//	    	  throw new ServerException("服务异常:"+errorInfo.getMessage());
//	      }
	      return result;
	}

}
