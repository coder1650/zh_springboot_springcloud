package com.zh.dao.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.dao.mapper.order.PayCpOrderInfoMapper;
import com.zh.model.entity.order.PayCpOrderInfo;

@RestController
@RequestMapping("/orderApi")
public class PayCpOrderInfoApi {
	@Autowired
	private PayCpOrderInfoMapper payCpOrderInfoMapper;
	
	
	@RequestMapping(value="insert",method=RequestMethod.POST,produces="application/json")
	public String insertPayCpOrderInfo(@RequestBody PayCpOrderInfo payCpOrderInfo){
		
		payCpOrderInfoMapper.insertPayCpOrderInfo(payCpOrderInfo);
		
		return "SUCCESS";
		
	}
	
	/**
	 * 根据trans_id查询订单信息
	 * @param transId
	 * {@link com.zh.model.remoteService.dao.OrderMapperService#findByTransId}
	 * @return
	 */
	@RequestMapping(value="findByTransId",method=RequestMethod.GET,produces="application/json")
	public PayCpOrderInfo findByTransId(@RequestParam("transId") String transId){
		return payCpOrderInfoMapper.findByTransId(transId);
	}
	
	/**
	 * 根据trans_id查询订单支付状态
	 * @param transId
	 * {@link com.zh.model.remoteService.dao.OrderMapperService#findPayStateOfOrderByTransId}
	 * @return
	 */
	@RequestMapping(value="findPayStateOfOrderByTransId",method=RequestMethod.GET,produces="application/json")
	public String findPayStateOfOrderByTransId(@RequestParam("transId") String transId){
		return payCpOrderInfoMapper.findPayStateOfOrderByTransId(transId);
	}
	

}
