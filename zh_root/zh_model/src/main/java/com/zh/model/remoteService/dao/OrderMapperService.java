package com.zh.model.remoteService.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.model.entity.order.PayCpOrderInfo;

@FeignClient("zh-dao")
public interface OrderMapperService {
	
	/**
	 * 查询订单信息
	 * @param transId
	 * @return
	 */
	@RequestMapping(value="/orderApi/findByTransId",method=RequestMethod.GET)
	public PayCpOrderInfo findByTransId(@RequestParam("transId") String transId);
	
	//插入订单信息
	@RequestMapping(value="/orderApi/insert",method=RequestMethod.POST)
	public String insertPayCpOrderInfo(PayCpOrderInfo payCpOrderInfo);
	
//	public SysCpAppPayMapping findCpAppPayMappingById(@RequestParam("id") String id);

}
