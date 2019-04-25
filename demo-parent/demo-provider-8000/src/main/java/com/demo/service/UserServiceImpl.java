package com.demo.service;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public String userRegister(User user) {

			user.setCreated(new Date());

			user.setUpdated(user.getCreated());

			userMapper.insert(user);

			return "注册成功";

	}

	@Override
	public String status() {
		return "服务1号";
	}

	@Override
	public List<User> findAll() {
		return userMapper.selectList(null);
	}

}
