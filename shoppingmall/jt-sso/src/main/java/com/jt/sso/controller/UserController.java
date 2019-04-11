package com.jt.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.sso.annotation.Erro;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;
import com.jt.sso.vo.SysResult;

import redis.clients.jedis.JedisCluster;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@RequestMapping("/{moduleName}")
	public String index(@PathVariable String moduleName) {
		
		return moduleName;
		
	}
	
//	@RequestMapping("/check/{param}/{type}")
//	public JSONPObject check(String callback,@PathVariable("param") String param,@PathVariable("type") Integer type) {
//		JSONPObject jsonObject = new JSONPObject(callback,SysResult.build(201, "OK", "false"));
//		switch(type) {
//		case 1:
//			if(userService.findUserByUserName(param)!=null)
//				jsonObject = new JSONPObject(callback,SysResult.build(200, "OK", "true"));	
//		case 2:
//			if(userService.findUserByPhone(param)!=null)
//				jsonObject = new JSONPObject(callback,SysResult.build(201, "OK", "true"));	
//		case 3:
//			if(userService.findUserByEmail(param)!=null)
//				jsonObject = new JSONPObject(callback,SysResult.build(201, "OK", "true"));
//		}
//		
//		return jsonObject;
//		
//	}
	@RequestMapping("/check/{param}/{type}")
	@Erro
	public JSONPObject findCheckUser(@PathVariable String param,@PathVariable Integer type, String callback) {
		
		boolean flag = userService.findCheckUser(param,type);
		
		SysResult result = SysResult.oK(flag);
		
		return new JSONPObject(callback,result);
		
	}
	
	// 实现用户入库操作
	@RequestMapping("/register")
	@Erro
	public SysResult saveUser(User user) {
		
		userService.saveUser(user);
		
		return SysResult.oK(); // 其实那个username传与不传都可以
	}
	
	// 实现用户登录操作http://sso.jt.com/user/login
	@RequestMapping("/login")
	@Erro
	public SysResult findUserByUP(User user) { // 前面传过来的是Username还有Password,用user接收
		try {
			
			// 安全起见，对user进行校验一下
			
			String token = userService.findUserByUP(user);
			
			if(!StringUtils.isEmpty(token)) {
			
				// 但是如果你对了，给你返回ok
				return SysResult.oK(token);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		// 防止个别一些情况，假设我不返回，永远给你返回错
		return SysResult.build(201,"用户登录失败");
		
	}
	
	// sso.jt.com/user
	// 实现用户信息回显JSONP
	@RequestMapping("/query/{token}")
	public JSONPObject findUserByToken(@PathVariable String token,String callback) {
		
		String userJSON = jedisCluster.get(token);
		
		SysResult result = null;
		// 判断数据是否存在
		if(StringUtils.isEmpty(userJSON)) {
			// 表示当前的用户登录不完整。业务就不能正确的返回
			result = SysResult.build(201,"用户查询有误");
		} else {
			// 必须返回用户的JSON数据
			result = SysResult.oK(userJSON);
		}
		
		return new JSONPObject(callback,result);
	}
	
	
}
