package com.zh.dao.mapper.configInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;

@Mapper
public interface ChannelConfigInfoMapper {
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findCpAppPayMappingById")
	public SysCpAppPayMapping findCpAppPayMappingById(@Param("id") String id);
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findCpMerchantConfigById")
	public SysCpMerchantConfig findCpMerchantConfigById(@Param("id") String id);
	
	@SelectProvider(type=ChannelConfigInfoSqlProvider.class,method="findPayChannelConfigById")
	public SysPayChannelConfig findPayChannelConfigById(@Param("id") String id);

}
