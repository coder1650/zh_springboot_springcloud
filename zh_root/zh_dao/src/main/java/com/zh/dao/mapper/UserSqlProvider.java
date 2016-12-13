package com.zh.dao.mapper;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {
	
	public String findByUserName(final String userName){
		return new SQL(){{
			SELECT("*");
			FROM("USER");
			WHERE("USER_NAME=#{userName}");
		}}.toString();
	}
	
	public String findAll(){
		return new SQL(){{
			SELECT("*");
			FROM("USER");
		}}.toString();
	}
}
