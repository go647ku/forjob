package com.demo.service;


import com.demo.factory.UserServiceFallBackFactory;
import com.demo.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider-user",fallbackFactory= UserServiceFallBackFactory.class)
public interface UserService {

	@RequestMapping(value = "/userRegister/{username}/{password}")
	String userRegister(User user);
}
