package com.zh.model.customException;

import com.zh.model.entity.ResultInfo;

import feign.FeignException;

public class GlobalException extends FeignException{

	private static final long serialVersionUID = -587581828119391009L;
	private ResultInfo resultInfo;

	public GlobalException(String message) {
		super(message);
	}

	public ResultInfo getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(ResultInfo resultInfo) {
		this.resultInfo = resultInfo;
	}

	
	
	
}
