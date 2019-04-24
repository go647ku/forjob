/*
package com.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {
	
	// 这里我们需要创建三个bean ShiroFilterFactoryBean、创建DefaultWebSecurityManager、创建Realm
	
	*/
/**
	 * 创建ShiroFilterFactoryBean
	 *//*

	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactory(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		// Shiro 内置过滤器(用来实现对URL 的一些拦截)
		*/
/**
		 * Shiro 内置过滤器，可以实现权限相关的拦截器
		 * 	常用的过滤器：
		 * 		anon: 无需认证(登录)就可以访问
		 * 		authc: 必须认证才可以访问
		 * 		user: 如果使用rememberMe 的功能可以直接访问
		 * 		perms: 该资源必须得到资源权限才可以访问
		 * 		role: 该资源必须得到角色权限才可以访问
		 *//*

		
		// 为了保证顺序可以用LinkedHashMap
		Map<String,String> filterMap = new LinkedHashMap<>();
		
		// filterMap.put("/user/add","authc");
		
		// filterMap.put("/user/update","authc");
		
		// filterMap.put("/user/testThymeleaf","anon");
		
		// 放行login 的请求
		filterMap.put("/user/login","anon");
		
		// 授权过滤,使用perms需要加字符串
		// 注意:当前授权拦截后，shiro 会自动跳转到未授权页面
		filterMap.put("/user/add", "perms[user:add]");
		
		filterMap.put("/user/update", "perms[user:update]");
		
		// 可以使用通配的方式
		filterMap.put("/user/*","authc");
		
		// 以上便是成功实现了对页面请求的一些拦截
		
		// 修改跳转的登录页面
		shiroFilterFactoryBean.setLoginUrl("/user/index");
		
		// 设置未授权提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/user/unAuth");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		
		return shiroFilterFactoryBean;
		
	}
	
	*/
/**
	 * 创建DefaultWebSecurityManager
	 *//*

	@Bean("securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		
		// 关联realm
		securityManager.setRealm(userRealm);
		
		return securityManager;
	}
	
	*/
/**
	 * 创建Realm
	 *//*

	@Bean
	public UserRealm getRealm() {
		
		return new UserRealm();
		
	}
	
	*/
/**
	 * 配置ShiroDialect ,用于thymeleaf 和shiro 标签配合使用
	 *//*

	@Bean
	public ShiroDialect getShiroDialect() {
		
		return new ShiroDialect();
		
	}
}
*/
