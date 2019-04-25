package com.demo.service;


import com.demo.factory.UserServiceFallBackFactory;
import com.demo.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "provider-user",fallbackFactory= UserServiceFallBackFactory.class)
public interface UserService {

	@RequestMapping(value = "/userRegister")
	String userRegister(@RequestBody User user);

	@RequestMapping("/status")
	String status();

	@RequestMapping("/findAll")
	List<User> findAll();
}
