package com.zh.test.controller;

import org.springframework.context.annotation.Configuration;

import feign.Response;
import feign.codec.ErrorDecoder;

@Configuration
public class Test500Decoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		System.out.println(methodKey+":"+response.status());
		return null;
	}
	
	

}
