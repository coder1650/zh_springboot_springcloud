package com.zh.mapper.configInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.zh.entity.configInfo.SysCpAppPayMapping;
import com.zh.entity.configInfo.SysCpMerchantConfig;
import com.zh.entity.configInfo.SysPayChannelConfig;

@Mapper
public interface ChannelConfigInfoMapper {
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findCpAppPayMappingById")
	public SysCpAppPayMapping findCpAppPayMappingById(@Param("id") String id);
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findCpMerchantConfigById")
	public SysCpMerchantConfig findCpMerchantConfigById(@Param("id") String id);
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findPayChannelConfigById")
	public SysPayChannelConfig findPayChannelConfigById(@Param("id") String id);

}
