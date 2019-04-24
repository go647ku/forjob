package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// 用户控制层
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userRegister")
	public String userRegister(@RequestBody User user) {

		return userService.userRegister(user);

	}

	@RequestMapping("/status")
	public String status(){

		return userService.status();

	}


}
