package com.zh.dao.mapper.order;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;

import com.zh.model.entity.order.PayCpOrderInfo;

@Mapper
public interface PayCpOrderInfoMapper {
	
	@InsertProvider(type=PayCpOrderInfoSqlProvider.class,method="insertPayCpOrderInfo")
	@SelectKey(before=true,keyProperty="id",resultType=String.class,statementType=StatementType.STATEMENT,statement="SELECT REPLACE(UUID(),'-','') FROM DUAL") 
	public void insertPayCpOrderInfo(PayCpOrderInfo payCpOrderInfo);
	
	@SelectProvider(type=PayCpOrderInfoSqlProvider.class,method="findByTransId")
	public PayCpOrderInfo findByTransId(@Param("transId") String tansId);
	
	

}
