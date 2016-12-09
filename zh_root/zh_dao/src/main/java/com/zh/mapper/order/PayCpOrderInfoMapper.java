package com.zh.mapper.order;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import com.zh.entity.order.PayCpOrderInfo;

@Mapper
public interface PayCpOrderInfoMapper {
	
	@InsertProvider(type=PayCpOrderInfoSqlProvider.class,method="insertPayCpOrderInfo")
	@SelectKey(before=true,keyProperty="id",resultType=String.class,statementType=StatementType.STATEMENT,statement="SELECT REPLACE(UUID(),'-','') FROM DUAL") 
	public void insertPayCpOrderInfo(PayCpOrderInfo payCpOrderInfo);

}
