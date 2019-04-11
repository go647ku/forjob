package com.jt.sso.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.sso.annotation.Erro;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;
import com.jt.sso.util.ObjectMapperUtil;

import redis.clients.jedis.JedisCluster;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired(required=false)
	private UserMapper userMapper;
	
	@Autowired
	private JedisCluster jedisCluster;

	@Override
	@Erro
	public boolean findCheckUser(String param, Integer type) {
		
		String column = null;
		
		switch(type) {
		case 1:
			column = "username";
			break;
		case 2:
			column = "phone";
			break;
		case 3:
			column = "email";
			break;
		}
		
		QueryWrapper<User> queryWrapper = new QueryWrapper();
		
		queryWrapper.eq(column, param);
		
		int count = userMapper.selectCount(queryWrapper);
		
		return count==0?false:true;
	}
	
	@Transactional // SpringBoot默认开启事务开关，但是你的注解需要加上否则事务没人控制
	@Erro
	@Override
	public void saveUser(User user) {
		
		// 补齐我们的数据
		// 暂时用写死Phone将Email用电话代替
		user.setEmail(user.getPhone())
			.setCreated(new Date())
			.setUpdated(user.getCreated());
		userMapper.insert(user);
	}
	
	/**
	 * 1.先查询数据库判断用户是否正确
	 */
	@Override
	@Erro
	public String findUserByUP(User user) {
		String token = null;
		
		// DB表示从数据库查询出的数据
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		
		queryWrapper.eq("username",user.getUsername())
					.eq("password", user.getPassword());
		
		User userDB = userMapper.selectOne(queryWrapper);
		
		// 判断用户数据是否存在
		if(userDB != null) {
			// 取非，表示里面有数据
			// 这代码写的还可以，有营养
			
			String tokenString = "JT_TICKET" + System.currentTimeMillis() + userDB.getUsername();
			
			token = DigestUtils.md5DigestAsHex(tokenString.getBytes());
			
			// 为了安全将密码擦除
			userDB.setPassword("你猜猜!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			String userJSON = ObjectMapperUtil.toJson(userDB);
			
			jedisCluster.set(token, userJSON);
			
			// 一切返回正常，直接返回token
			return token;
	
		}
			
		return token;
	}

//	@Override
//	public User findUserByUserName(String param) {
//		QueryWrapper queryWrapper = new QueryWrapper();
//		queryWrapper.eq("username", param);
//		return userMapper.selectOne(queryWrapper);
//	}
//
//	@Override
//	public User findUserByPhone(String param) {
//		QueryWrapper queryWrapper = new QueryWrapper();
//		queryWrapper.eq("phone", param);
//		return userMapper.selectOne(queryWrapper);
//	}
//
//	@Override
//	public User findUserByEmail(String param) {
//		QueryWrapper queryWrapper = new QueryWrapper();
//		queryWrapper.eq("email", param);
//		return userMapper.selectOne(queryWrapper);
//	}
	
}
