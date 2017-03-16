package com.zh.web.api;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.model.remoteService.service.PayServiceRemoteService;


/**
 * h5支付入口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/h5PayApi")
public class H5PayController {
	@Autowired
	private PayServiceRemoteService payServiceRemoteService;
	
	@RequestMapping(value="getForwardPayUrl",method=RequestMethod.GET,produces="application/json")
	public String getForwardPayUrl(@RequestParam("transId") String transId,@RequestParam("typeId") int payMappingId,
			HttpServletResponse httpResponse) throws IOException{
		String forwardPayUrl = payServiceRemoteService.getForwardPayUrl(transId,payMappingId);
		httpResponse.setContentType("text/html;charset=UTF-8");
		httpResponse.getWriter().write(forwardPayUrl);
		return null;
	}

}
