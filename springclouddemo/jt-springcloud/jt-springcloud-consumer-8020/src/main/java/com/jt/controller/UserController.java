package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

@RestController
@RequestMapping("/consumer")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//实现查询方法
	@RequestMapping("/findAll")
	public List<User> findAll(){
		
		return userService.findAll();
		
	}
	
	@RequestMapping("/saveUser/{name}/{age}/{sex}")
	public String saveUser(User user) {

	return userService.saveUser(user);

}
	
	// 消费者 删除用户信息
	@RequestMapping("/delete/{id}")
	public String deleteUserById(User user) {

		return userService.deleteUserById(user);

	}
	
	// 获取服务端信息
	@RequestMapping("/getMsg")
	public String getMsg() {
		
		return userService.getMsg();
	}

	// 消费者 修改用户信息
	@RequestMapping("/update/{id}/{name}/{sex}/{age}")
	public String updateUserById(User user) {

		return userService.updateUserById(user);

	}
//	// 切换服务名称
//	private static final String PROVAIDER_URL = "http://provider-user/";
//
//	@Autowired
//	private RestTemplate restTemplate;
//
//	// 消费者获取服务端数据
//	@SuppressWarnings("unchecked")
//	@RequestMapping("/findAll")
//	public List<User> findAll(){
//
//		String url = PROVAIDER_URL + "findAll";
//
//		return restTemplate.getForObject(url, List.class);
//
//	}
//
//	// 消费者 新增用户信息
//	@RequestMapping("/saveUser/{name}/{age}/{sex}")
//	public String saveUser(User user) {
//
//		String url = PROVAIDER_URL + "saveUser";
//
//		/**
//		 *	参数说明：
//		 *	1.url 访问服务端地址
//		 *	2.request 	传递的参数对象
//		 *	3.responseType 	响应的对象类型 		
//		 */
//		// 使用post 提交用户数据
//		// 这里也是把user打成了串进行了传递
//		return restTemplate.postForObject(url, user, String.class);
//
//	}
//
//	// 消费者 删除用户信息
//	@RequestMapping("/delete/{id}")
//	public String deleteUserById(User user) {
//
//		String url = PROVAIDER_URL + "deleteUser";
//
//		return restTemplate.postForObject(url, user, String.class);
//
//	}
//
//	// 消费者 修改用户信息
//	@RequestMapping("/update/{id}/{name}/{sex}/{age}")
//	public String updateUserById(User user) {
//
//		String url = PROVAIDER_URL + "updateUser";
//
//		return restTemplate.postForObject(url, user, String.class);
//
//	}
//	
//	// 获取服务端信息
//	@RequestMapping("/getMsg")
//	public String getMsg() {
//		
//		String url = PROVAIDER_URL + "getMsg";
//		
//		return restTemplate.getForObject(url, String.class);
//	}
}
