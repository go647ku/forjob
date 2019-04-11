package com.jt.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
import com.jt.web.service.UserService;

import redis.clients.jedis.JedisCluster;


@Controller
@RequestMapping("/user")
public class UserController {
		
		@Autowired
		private UserService userService;
		
		@Autowired
		private JedisCluster jedisCluster;
	
		@RequestMapping("/{moduleName}")
		public String index(@PathVariable String moduleName) {
			
			return moduleName;
			
		}
		
		// 实现前台用户的新增
		@RequestMapping("/doRegister")
		@ResponseBody
		public SysResult saveUser(User user) {
			
			userService.saveUser(user);
			
			return SysResult.oK();
		}
		
		@RequestMapping("/doLogin")
		@ResponseBody
		public SysResult findUserByUP(HttpServletResponse response,User user) {
			try {
				
				String token = userService.findUserByUP(user);
				
				if(!StringUtils.isEmpty(token)) {
					// 如果token有数据，则保存到cookie中
					Cookie cookie = new Cookie("JT_TICKET",token);
					
					cookie.setMaxAge(7*24*3600); // 设定Cookie存活时间
					
					cookie.setPath("/"); // 权限
					
					response.addCookie(cookie);
					
					return SysResult.oK();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SysResult.build(201, "用户名或密码错误");
		}
	
		// 实现用户登出操作
		// 1.先获取Cookie，之后获取 token数据
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request,HttpServletResponse response) {
			
			String token = null;
			
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie:cookies) {
				
				if("JT_TICKET".equals(cookie.getName())) {
					
					token = cookie.getValue();
					
					break;
					
				}
				
			}
			
			// 先删除redis
			jedisCluster.del(token);
			
			// 删除Cookie
			Cookie cookie = new Cookie("JT_TICKET","");// 建议不要写NULL，有的浏览器会报异常
			
			cookie.setMaxAge(0); // 写0立即删除
			
			cookie.setPath("/"); // 权限也要加
			
			response.addCookie(cookie);
			
			// 重定向到我们的系统首页
			return "redirect:/index.html";
			
		}
}
