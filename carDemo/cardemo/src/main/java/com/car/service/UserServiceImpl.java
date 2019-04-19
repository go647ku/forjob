package com.car.service;

import java.util.Date;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.car.mapper.UserMapper;
import com.car.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void userRegister(String username, String password) {
		
		User user = new User();
		
		user.setUsername(username).setPassword(password).setCreated(new Date());
		
		user.setUpdated(user.getCreated());
		
		userMapper.insert(user);
		
	}

	@Override
	public boolean userLogin(String username, String password) {
		
		User user = new User().setUsername(username).setPassword(password);
		
		System.out.println(userMapper.selectCount(new QueryWrapper(user)));
		
		return userMapper.selectCount(new QueryWrapper(user))!=0?true:false;
		
	}

	@Override
	public User findUserById(Integer uId) {
		
		return userMapper.selectById(uId);
	}

	@Override
	public User findUserByName(String username) {
		
		return userMapper.selectOne(new QueryWrapper(new User().setUsername(username)));
	}
	
}
