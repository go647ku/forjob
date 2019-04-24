package com.demo.controller;


import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister/{username}/{password}")
    public String userRegister(User user) {

        return userService.userRegister(user);

    }



}
