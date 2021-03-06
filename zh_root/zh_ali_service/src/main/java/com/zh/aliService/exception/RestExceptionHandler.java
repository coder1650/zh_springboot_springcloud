package com.zh.aliService.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import com.zh.model.constant.ReturnCode;
import com.zh.model.customException.GlobalException;
import com.zh.model.entity.ResultInfo;
import com.zh.model.util.JsonUtil;


@ControllerAdvice
public class RestExceptionHandler extends AbstractMappingJacksonResponseBodyAdvice{
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo jsonErrorHandler(HttpServletRequest req,HttpServletResponse resp, Exception e) throws IOException {
		ResultInfo resultInfo = null;
		if(e.getCause() instanceof GlobalException){
			resultInfo = ((GlobalException) e.getCause()).getResultInfo();
		}else{
			resultInfo = new ResultInfo();
			resultInfo.setReturnCode(ReturnCode.SERVICE_ERROR);
			resultInfo.setHttpStatus(resp.getStatus());
			resultInfo.setMsg("ali_service层:"+e.getMessage());
			resultInfo.setUrl(req.getRequestURL().toString());
		}
		logger.error("RestExceptionHandler catch exception:"+JsonUtil.getString(resultInfo));
        return resultInfo;
    }
	
	/**
	 * 拦截：当controller的方法上有@ResponseBody注解时，返回值在序列化为json之前，会调用该方法
	 * Invoked only if the converter type is {@code MappingJackson2HttpMessageConverter}
	 * 由于当controller直接返回支付串时，是不走MappingJackson2HttpMessageConverter这个类的，所以只能在
	 * {@link com.zh.aliService.aspect.RecordLogAop#doAround}类中把返回值包装到ResultInfo中
	 */
	@Override
	protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType,
			MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
		if(bodyContainer.getValue() instanceof ResultInfo){
			return;
		}
		ResultInfo result = new ResultInfo();
		result.setReturnCode(ReturnCode.SERVICE_OK);
		ServletServerHttpResponse resp = (ServletServerHttpResponse)response;
		result.setHttpStatus(resp.getServletResponse().getStatus());
		result.setData(bodyContainer.getValue());
		bodyContainer.setValue(result);
	}

}
