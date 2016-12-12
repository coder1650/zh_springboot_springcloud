package com.zh.api.configInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.entity.configInfo.SysCpAppPayMapping;
import com.zh.entity.configInfo.SysCpMerchantConfig;
import com.zh.entity.configInfo.SysPayChannelConfig;
import com.zh.mapper.configInfo.ChannelConfigInfoMapper;

@RestController
@RequestMapping("/configInfoApi")
public class ConfigInfoApi {
	
	@Autowired
	private ChannelConfigInfoMapper channelConfigInfoMapper;
	
	/**
	 * 查询商户应用支付方式关系表信息
	 * @param id
	 * @return
	 */
	public SysCpAppPayMapping findCpAppPayMappingById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findCpAppPayMappingById(id);
	}
	
	/**
	 * 查询平台的支付渠道账户信息配置表信息
	 * @param id
	 * @return
	 */
	public SysCpMerchantConfig findCpMerchantConfigById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findCpMerchantConfigById(id);
	}
	
	/**
	 * 查询支付渠道配置表信息
	 * @param id
	 * @return
	 */
	public SysPayChannelConfig findPayChannelConfigById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findPayChannelConfigById(id);
	}
	
	

}
