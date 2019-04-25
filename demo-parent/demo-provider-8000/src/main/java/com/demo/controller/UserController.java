package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 用户控制层
@Api("服务提供者1号接口")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userRegister",method = RequestMethod.GET)
	@ApiOperation("/userRegister方法")
	public String userRegister(@RequestBody User user) {

		return userService.userRegister(user);

	}

	@RequestMapping(value = "/status",method = RequestMethod.GET)
	@ApiOperation("/status方法")
	public String status(){

		return userService.status();

	}

	@RequestMapping(value = "/findAll",method = RequestMethod.GET)
	@ApiOperation("/findAll方法")
	public List<User> findAll(){

		return userService.findAll();

	}


}
