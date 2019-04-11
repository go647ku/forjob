package com.jt.manage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.User;
import com.jt.manage.service.UserService;

@Controller
public class UseController {
	@Autowired
	private UserService userService;
	
	
	
	//查询user信息进行页面展现jsp
	//page 只对当前jsp生效
	//request 对用户的一次请求生效
	//session 对当前用户会话生效
	//context 服务器作用域
	
	@RequestMapping("/findAll")
	
	public String findList(Model model) {
		List<User> findList = userService.findList();
		model.addAttribute("userList", findList);
		return "userList";
	}
	
	
	
	
}
