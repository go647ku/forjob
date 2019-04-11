package com.jt.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.springcloud.factory.UserServiceFallBackFactory;
import com.jt.springcloud.pojo.User;

@FeignClient(value = "provider-user",fallbackFactory=UserServiceFallBackFactory.class)
public interface UserService {
		// 获取用户JSON信息
		@RequestMapping("/findAll")
		List<User> findAll();

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
		String saveUser(@RequestBody User user);

		// deleteUser
		@RequestMapping("/deleteUser")
		@ResponseBody
		String deleteUserById(@RequestBody User user);

		// updateUser
		@RequestMapping("/updateUser")
		@ResponseBody
		String updateUserById(@RequestBody User user);

		@ResponseBody
		@RequestMapping("/getMsg")
		String getMsg();

	}
