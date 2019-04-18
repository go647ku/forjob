package com.car.service;

import com.car.pojo.User;

public interface UserService {

	void userRegister(String username, String password);

	boolean userLogin(String username, String password);

	
}
