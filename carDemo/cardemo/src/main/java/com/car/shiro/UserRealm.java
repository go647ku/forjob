package com.car.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.service.UserService;

/**
 * 自定义Realm
 * @author Acer
 *特点：继承一个 AuthorizingRealm
 */
@Component
public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	UserService userService;
	
	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		return null;
	}
	
	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		// 获取数据库的用户名和密码
		String username = "lige666";
		
		String password = "qwer1234";
		
		// 1.判断用户名
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		
		if(!token.getUsername().equals(username)) {
			
			// 用户名不存在
			return null;// shiro 底层会抛出一个UnknowAccountException

		}
		
		// 2.判断密码(不需要我们来判断)
		// 第一个参数是需要返回给login 方法的一些数据，可以留空
		// 第二个参数就是我们数据库的密码
		// 第三个是shiro的名字，也可以留空
		return new SimpleAuthenticationInfo("", password, "");
	}
	
	
}
