package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister/{username}/{password}")
    public String userRegister(User user) {

        return userService.userRegister(user);

    }

    @RequestMapping("/status")
    public String status(){

        return userService.status();

    }

    @RequestMapping("/findAll")
    public List<User> findAll(){

        return userService.findAll();

    }

}
