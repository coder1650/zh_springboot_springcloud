package com.zh.dao.exception;


import javax.servlet.http.HttpServletRequest;

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
import com.zh.model.entity.ResultInfo;

@ControllerAdvice
public class RestExceptionHandler extends AbstractMappingJacksonResponseBodyAdvice{
	
	/**
	 * 拦截controller层所有的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo jsonErrorHandler(HttpServletRequest req, Exception e) {
		ResultInfo result = new ResultInfo();
		result.setReturnCode(ReturnCode.SERVICE_ERROR);
		result.setHttpStatus(ReturnCode.HTTP_EXCEPTION_CODE);
		String message = "";
		if(e instanceof NullPointerException){
			message = "空指针异常:";
		}
		result.setMsg("dao层："+message+e.getLocalizedMessage());
		result.setUrl(req.getRequestURL().toString());
        return result;
    }

	/**
	 * 拦截：当controller的方法上有@ResponseBody注解时，返回值在序列化为json之前，会调用该方法
	 * Invoked only if the converter type is {@code MappingJackson2HttpMessageConverter}
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
