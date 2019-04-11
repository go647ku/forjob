package com.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.pojo.User;
import com.car.service.UserService;

// 用户控制层
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userRegister/{username}/{password}")
	public String userRegister(@PathVariable String username,@PathVariable String password) {
		
		userService.userRegister(username, password);
		
		return "注册成功";
		
	}
	
	@RequestMapping("/userLogin/{username}/{password}")
	public String userLogin(User user) {
		
		if(userService.userLogin(user))
		return "登录成功";
		
		return "用户名或密码错误";
		
	}
	
}
