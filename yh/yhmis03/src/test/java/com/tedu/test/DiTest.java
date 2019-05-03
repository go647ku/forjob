package com.tedu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.hello.Dept;
import com.tedu.hello.User;

/**
 * 这个类是用来测试Di的
 *
 */
public class DiTest {
	// 测试set注入方式
	@Test
	public void di(){
		// 加载核心配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取user对象并打印
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
	
	// 测试构造方法注入
	@Test
	public void construct(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dept dept = (Dept) ac.getBean("dept");
		System.out.println(dept);
	}
}
