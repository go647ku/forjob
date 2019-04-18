package com.car.controller;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.pojo.User;
import com.car.service.UserService;

// 用户控制层
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userRegister/{username}/{password}")
	@ResponseBody
	public String userRegister(@PathVariable String username,@PathVariable String password) {
		
		userService.userRegister(username, password);
		
		return "注册成功";
		
	}
	
	@RequestMapping(value = "/login")
	public String userLogin(String username,String password,Model model) {
//		
//		if(userService.userLogin(username,password))
//			return "登录成功";
//		
//		return "用户名或密码错误";
		/**
		 * 使用Shiro 编写认证操作
		 */
		// 1.获取Subject
		Subject subject = SecurityUtils.getSubject();
		
		// 2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		// 3.执行登录方法
		try {
			subject.login(token);
			
			// 登录成功
			// 跳转到test 页面
			return "redirect:/user/testThymeleaf";
			
		}catch(UnknownAccountException e) {
			
			// e.printStackTrace();
			
			// 登录失败：用户名不存在
			model.addAttribute("msg","用户不存在");
			
			return "login";
		}catch (IncorrectCredentialsException e) {

			model.addAttribute("msg","密码错误");
			
			return "login";
		}
	}
	
	@RequestMapping("/index")
	public String Index() {
		
		return "login";
		
	}
	
	/**
	 * 测试 thymeleaf
	 */
	@RequestMapping("/testThymeleaf")
	public String testThymeleaf(Model model) {
		
		model.addAttribute("name","李哥666");
		
		return "testHtml";
		
	}
	
	@RequestMapping("/add")
	public String jumpAdd() {
		
		return "/user/add";
		
	}
	
	@RequestMapping("/update")
	public String jumpUpdate() {
		
		return "/user/update";
		
	}
}
