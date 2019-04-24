package com.demo.factory;


import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.stereotype.Component;


import feign.hystrix.FallbackFactory;

@Component
public class UserServiceFallBackFactory implements FallbackFactory<UserService>{
	
	@Override
	public UserService create(Throwable cause) {
		
		return new UserService() {

			@Override
			public String userRegister(User user) {

				cause.printStackTrace();

				return "注册失败";
			}

			@Override
			public String status(){

				return "请等待";

			}

		};
	}



	
}
