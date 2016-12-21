package com.zh.web.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 定义环绕通知，用于拦截所有controller的入参和出参
 * @author Administrator
 */
@Aspect
@Configuration
public class RecordLogAop {
	private Logger logger = LoggerFactory.getLogger(RecordLogAop.class);
	
	/**
	 * 定义切点
	 */
	@Pointcut("execution(* com.zh.web.api..*.*(..))")
	public void executionPoint(){}
	
	/**
	 * 定义环绕通知，拦截controller被调用前和被调用后
	 * @param pjp
	 * @return
	 * @throws Throwable 
	 */
	@Around("executionPoint()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
		Object result = null;
		try {
			// result的值就是被拦截方法的返回值
			result = pjp.proceed();
			ObjectMapper om = new ObjectMapper();
			logger.info("请求结束，controller的返回值是 " + om.writeValueAsString(result));
		} catch (Throwable e) {
			if(e instanceof JsonProcessingException){
				logger.error("获取controller返回之后，转换成转换成json字符串失败!");
			}else{
				logger.error("获取controller返回值失败!");
			}
			throw e;
		}
		return result;

	}

}
