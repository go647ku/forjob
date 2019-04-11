package com.jt.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.springcloud.mapper.UserMapper;
import com.jt.springcloud.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() {
		
		return userMapper.selectList(null);
	
	}
	
	@Transactional
	@Override
	public void saveUser(User user) {
		
		userMapper.insert(user);
		
	}
	
	@Transactional
	@Override
	public void deleteUserById(Integer id) {
		
		userMapper.deleteById(id);
		
	}	
	
}
