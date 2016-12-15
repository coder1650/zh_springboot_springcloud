package com.zh.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zh.model.customException.ErrorInfo;

@ControllerAdvice
public class RestExceptionHandler{
	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) {
		ErrorInfo<String> errorInfo = new ErrorInfo<>();
		errorInfo.setCode(ErrorInfo.ERROR);
		String message = null;
		if(e instanceof NullPointerException){
			message = "sevice层:空指针异常";
		}
		errorInfo.setMessage(message+e.getMessage());
		errorInfo.setUrl(req.getRequestURL().toString());
        return errorInfo;
    }

}
