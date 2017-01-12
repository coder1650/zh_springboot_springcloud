package com.zh.dao.api.configInfo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.dao.mapper.configInfo.ChannelConfigInfoMapper;
import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;


@RestController
@RequestMapping("/configInfoApi")
public class ConfigInfoApi {
	private Logger logger = LoggerFactory.getLogger(ConfigInfoApi.class);
	@Autowired
	private ChannelConfigInfoMapper channelConfigInfoMapper;
	
	/**
	 * 查询商户应用支付方式关系表信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findCpAppPayMappingById",method=RequestMethod.GET,produces="application/json")
	public SysCpAppPayMapping findCpAppPayMappingById(@RequestParam("id") String id){
		logger.info("this is test logback log");
		SysCpAppPayMapping cpApp = channelConfigInfoMapper.findCpAppPayMappingById(id);
		return cpApp;
	}
	
	/**
	 * 查询平台的支付渠道账户信息配置表信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findCpMerchantConfigById",method=RequestMethod.GET,produces="application/json")
	public SysCpMerchantConfig findCpMerchantConfigById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findCpMerchantConfigById(id);
	}
	
	/**
	 * 查询支付渠道配置表信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findPayChannelConfigById",method=RequestMethod.GET,produces="application/json")
	public SysPayChannelConfig findPayChannelConfigById(@RequestParam("id") String id){
		return channelConfigInfoMapper.findPayChannelConfigById(id);
	}
	
	/**
	 * 根据应用编号查询该应用支持的支付方式
	 * @param appId  应用编号
	 * @param platType 平台类型
	 *{@link com.zh.model.remoteService.dao.ConfigInfoMapperRemoteService#findPayTypeInfoOfAppId}
	 * @return
	 */
	@RequestMapping(value="/findPayTypeInfoOfAppId",method=RequestMethod.GET,produces="application/json")
	public List<PayTypeInfo> findPayTypeInfoOfAppId(@RequestParam("appId") String appId,@RequestParam("platType") String platType){
		return channelConfigInfoMapper.findPayTypeInfoOfAppId(appId,platType);
	}
}
