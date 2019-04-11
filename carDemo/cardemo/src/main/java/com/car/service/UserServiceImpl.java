package com.car.service;

import java.util.Date;

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
	public boolean userLogin(User user) {
		
		if(userMapper.selectCount(new QueryWrapper(user))!=null)
			return true;
		
		return false;
		
	}
	
}