package com.zh.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.github.pagehelper.Page;
import com.zh.model.demo.User;

@Mapper
public interface UserMapper {
	@SelectProvider(type=UserSqlProvider.class,method="findByUserName")
	public User findByName(@Param("userName") String userName);
	
	@SelectProvider(type=UserSqlProvider.class,method="findAll")
	public Page<User> findAll();
}
