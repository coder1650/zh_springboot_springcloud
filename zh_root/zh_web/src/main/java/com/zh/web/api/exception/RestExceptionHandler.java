package com.zh.web.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.zh.model.customException.ErrorInfo;

@ControllerAdvice
public class RestExceptionHandler{
	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) {
		ErrorInfo<String> errorInfo = new ErrorInfo<>();
		errorInfo.setCode(ErrorInfo.ERROR);
		String message = null;
		if(e instanceof HystrixRuntimeException){
			message = e.getCause().getMessage();
		}
		errorInfo.setMessage(message);
		errorInfo.setUrl(req.getRequestURL().toString());
        return errorInfo;
    }

}
