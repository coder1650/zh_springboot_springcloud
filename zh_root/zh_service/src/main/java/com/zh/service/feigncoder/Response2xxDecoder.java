package com.zh.service.feigncoder;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.model.constant.ReturnCode;
import com.zh.model.customException.GlobalException;
import com.zh.model.entity.ResultInfo;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.StringDecoder;

@Configuration
public class Response2xxDecoder extends StringDecoder {

	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		if (response.status() == 404)
			return Util.emptyValueOf(type);
		if (response.body() == null)
			return null;
		if (byte[].class.equals(type)) {
			return Util.toByteArray(response.body().asInputStream());
		}
		String result = Util.toString(response.body().asReader());

		ObjectMapper om = new ObjectMapper();
		ResultInfo resultInfo = om.readValue(result, ResultInfo.class);
		if (ReturnCode.SERVICE_OK.equals(resultInfo.getReturnCode())) {
			String str = om.writeValueAsString(resultInfo.getData());
			try {
				return om.readValue(str, Class.forName(type.getTypeName()));
			} catch (ClassNotFoundException e) {
				String msg = "bind data to controller return value error:ClassNotFoundException";
				GlobalException globalException = new GlobalException(msg);
				globalException.setResultInfo(resultInfo);
				throw globalException;
			}
		} else {
			GlobalException globalException = new GlobalException(resultInfo.getMsg());
			globalException.setResultInfo(resultInfo);
			throw globalException;
		}

	}

}
