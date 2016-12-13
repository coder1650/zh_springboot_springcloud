package com.zh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zh.dao.mapper.UserMapper;
import com.zh.model.demo.User;

@RestController
public class TestController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/test01")
	public String test01(@RequestParam("a") Integer a,@RequestParam("b") Integer b){
		PageHelper.startPage(1, 10, true);
		Page<User> page = userMapper.findAll();
		System.out.println(page.getTotal());
		User u = userMapper.findByName("zhangsan");
		System.out.println(u.getUserName());
		return String.valueOf((a+b));
	}
	
	@RequestMapping("/findUserByName")
	public User findUserByName(@RequestParam("userName") String userName){
		User u = userMapper.findByName("zhangsan");
		return u;
	}

}
