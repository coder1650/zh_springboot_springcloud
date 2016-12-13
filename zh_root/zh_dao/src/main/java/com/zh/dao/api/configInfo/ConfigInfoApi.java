package com.zh.dao.api.configInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.dao.mapper.configInfo.ChannelConfigInfoMapper;
import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;

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
	@RequestMapping(value="/findCpAppPayMappingById",method=RequestMethod.GET)
	public SysCpAppPayMapping findCpAppPayMappingById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findCpAppPayMappingById(id);
	}
	
	/**
	 * 查询平台的支付渠道账户信息配置表信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findCpMerchantConfigById",method=RequestMethod.GET)
	public SysCpMerchantConfig findCpMerchantConfigById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findCpMerchantConfigById(id);
	}
	
	/**
	 * 查询支付渠道配置表信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findPayChannelConfigById",method=RequestMethod.GET)
	public SysPayChannelConfig findPayChannelConfigById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findPayChannelConfigById(id);
	}
	
	

}
