package com.zh.web.api.exception;

/**
 * 服务提供方异常
 * @author Administrator
 *
 */
public class ServerException extends RuntimeException{
	
	public ServerException(){}

	public ServerException(String message) {
		super(message);
	}
	
	

}
