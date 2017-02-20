package com.zh.dao.mapper.configInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;

@Mapper
public interface ChannelConfigInfoMapper {
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findCpAppPayMappingById")
	public SysCpAppPayMapping findCpAppPayMappingById(@Param("id") int id);
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findCpMerchantConfigById")
	public SysCpMerchantConfig findCpMerchantConfigById(@Param("id") int id);
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findPayChannelConfigById")
	public SysPayChannelConfig findPayChannelConfigById(@Param("id") int id);
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findPayTypeInfoOfAppId")
	public List<PayTypeInfo> findPayTypeInfoOfAppId(@Param("appId") String appId,@Param("platType") String platType);

}
