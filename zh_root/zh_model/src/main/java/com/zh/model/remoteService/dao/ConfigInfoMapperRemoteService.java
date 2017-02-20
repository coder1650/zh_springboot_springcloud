package com.zh.model.remoteService.dao;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;

@FeignClient("zh-dao")
public interface ConfigInfoMapperRemoteService {
	
	@RequestMapping(value="/configInfoApi/findCpAppPayMappingById",method=RequestMethod.GET)
	public SysCpAppPayMapping findCpAppPayMappingById(@RequestParam("id") int id);
	
	@RequestMapping(value="/configInfoApi/findCpMerchantConfigById",method=RequestMethod.GET)
	public SysCpMerchantConfig findCpMerchantConfigById(@RequestParam("id") int id);
	
	@RequestMapping(value="/configInfoApi/findPayChannelConfigById",method=RequestMethod.GET)
	public SysPayChannelConfig findPayChannelConfigById(@RequestParam("id") int id);
	
	/**
	 * 根据应用编号查询该应用支持的支付方式
	 * @param appId  应用编号
	 * @param platType 平台类型<br/>
	 * {@link com.zh.dao.api.configInfo.ConfigInfoApi#findPayTypeInfoOfAppId}
	 * @return
	 */
	@RequestMapping(value="/configInfoApi/findPayTypeInfoOfAppId",method=RequestMethod.GET)
	public List<PayTypeInfo> findPayTypeInfoOfAppId(@RequestParam("appId") String appId,@RequestParam("platType") String platType);

}
