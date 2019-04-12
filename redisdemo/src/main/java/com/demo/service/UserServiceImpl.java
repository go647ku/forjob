package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.annotation.RequireJedis;
import com.demo.mapper.UserMapper;
import com.demo.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@RequireJedis("查询所有用户")
	@Override
	public String findAll() {
		
		return userMapper.selectList(null).toString();
	}

}
