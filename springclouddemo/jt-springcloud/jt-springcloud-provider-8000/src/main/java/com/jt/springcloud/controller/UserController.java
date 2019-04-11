package com.jt.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	// 获取用户JSON信息
	@RequestMapping("/findAll")
//	@HystrixCommand(fallbackMethod="hystrix_findAll") // 回退
	@HystrixCommand
	public List<User> findAll(){
		
//		int a=1/0;
		
		return userService.findAll();
		
	}
	
	public List<User> hystrix_findAll(){
		
		List<User> userList = new ArrayList<>();
		
		User user = new User();
		
		user.setId(0)
			.setName("")
			.setAge(0)
			.setSex("");
		
		userList.add(user);
		
		return userList;
		
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
	
	// updateUser
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUserById(@RequestBody User user) {
		
		userService.updateUserById(user);
		
		return "修改用户成功" + user.getId();
		
	}
	
	@ResponseBody
	@RequestMapping("/getMsg")
	public String getMsg() {
		
		return "我是提供者一号";
		
	}
}
