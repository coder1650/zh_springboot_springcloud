package com.zh.model.remoteService.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;

@FeignClient("zh-dao")
public interface ConfigInfoMapperRemoteService {
	
	@RequestMapping(value="/configInfoApi/findCpAppPayMappingById",method=RequestMethod.GET)
	public SysCpAppPayMapping findCpAppPayMappingById(@RequestParam("id") String id);
	
	@RequestMapping(value="/configInfoApi/findCpMerchantConfigById",method=RequestMethod.GET)
	public SysCpMerchantConfig findCpMerchantConfigById(@RequestParam("id") String id);
	
	@RequestMapping(value="/configInfoApi/findPayChannelConfigById",method=RequestMethod.GET)
	public SysPayChannelConfig findPayChannelConfigById(@RequestParam("id") String id);

}
