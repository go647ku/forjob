package com.demo.service;

import com.demo.pojo.User;

import java.util.List;

public interface UserService {

	String userRegister(User user);

    String status();

    List<User> findAll();
}
