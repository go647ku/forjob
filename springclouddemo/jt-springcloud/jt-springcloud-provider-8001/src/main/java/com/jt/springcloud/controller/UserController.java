package com.jt.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	// 获取用户JSON信息
	@RequestMapping("/findAll")
	public List<User> findAll(){
		
		return userService.findAll();
		
	}
	
	// 编辑提供者
	/**
	 * 	传过来的串就叫user
	 * @ResponseBody 	将对象转化为JSON
	 * @RequestBody	将JSON动态的转化为对像
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(@RequestBody User user) {
		
		userService.saveUser(user);
		
		return "新增用户成功:" + user.getName();
		
	}
	
	// deleteUser
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUserById(@RequestBody User user) {
		
		userService.deleteUserById(user.getId());
		
		return "删除用户成功" + user.getId();
	}
	
	@ResponseBody
	@RequestMapping("/getMsg")
	public String getMsg() {
		
		return "我是提供者二号";
		
	}
}
