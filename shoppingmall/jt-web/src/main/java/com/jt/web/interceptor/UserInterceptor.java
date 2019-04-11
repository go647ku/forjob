package com.jt.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.util.ObjectMapperUtil;
import com.jt.web.pojo.User;
import com.jt.web.util.UserThreadLocal;

import redis.clients.jedis.JedisCluster;

public class UserInterceptor implements HandlerInterceptor{

	@Autowired
	private JedisCluster jedisCluster;

	// 调用Controller方法执行之前
	/**
	 * 1.当用户发起请求时，首先进行拦截，判断用户信息是否登录
	 * 2.如果用户没有登录，则重定向到登录页面
	 * 3.如果用户已经登录，则放行
	 * 
	 * 问题：
	 * 	1.如何判断用户是否登录？？？
	 * 	首先获取Cookie信息，之后获取token,检查redis
	 * 	如果数据都存在，说明用户已经登录
	 * 	如果有一项为空，则表明用户未登录
	 * 
	 * 重点注意：
	 * 		拦截器每次都会拦截用户的/cart等敏感操作
	 * 		每次获取user数据保存再域对象中.
	 * 			
	 */
	@Override	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1.获取用户Cookie信息
		Cookie[] cookies = request.getCookies();

		if(cookies!=null) {

			String token = null;

			for(Cookie cookie : cookies) {

				if("JT_TICKET".equals(cookie.getName())){

					token = cookie.getValue();
					
					break;

				}

			}

			// 必须重定向到用户登录页面
			if(!StringUtils.isEmpty(token)) {

				// 2.判断redis中有无数据
				String userJSON = jedisCluster.get(token);
					
				if(!StringUtils.isEmpty(userJSON)) {

					// 获取用户信息
					
					User user = ObjectMapperUtil.toObject(userJSON, User.class);
					
					request.setAttribute("JT_USER", user);
					
					// 使用ThreadLocal封装我们的数据
					UserThreadLocal.set(user);
					
					return true;

				}
			
			}

		}
		response.sendRedirect("/user/login.html");

		return false; // false表示拦截，true表示放行
	}

	// Controller方法执行结束后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	// 把页面填充页面的过程叫做视图渲染
	// 视图渲染完成之后执行
	@Override // 关闭连接/关闭流(打大文件写入写出)(BIO阻塞式流)/删除某些对象防止内存泄漏
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		UserThreadLocal.remove();

	}

}
