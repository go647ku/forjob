package com.demo.service;

import java.util.Date;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void userRegister(String username, String password) {

		User user = new User();

		user.setUsername(username);

		user.setPassword(password);

		user.setCreated(new Date());

		user.setUpdated(user.getCreated());

		userMapper.insert(user);

	}

	@Override
	public boolean userLogin(String username, String password) {

		User user = new User();

		user.setUsername(username);

		user.setPassword(password);

		System.out.println(userMapper.selectCount(new QueryWrapper(user)));

		return userMapper.selectCount(new QueryWrapper(user))!=0?true:false;

	}

	@Override
	public User findUserById(Integer uId) {

		return userMapper.selectById(uId);
	}

	@Override
	public User findUserByName(String username) {

		User user = new User();

		user.setUsername(username);

		return userMapper.selectOne(new QueryWrapper(user));
	}

}
