package com.tedu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.hello.Hello;
import com.tedu.hello.User;

/**
 * 这个类用来测试spring的ioc功能
 */
public class IoCTest {
	@Test// 注解
	public void ioc(){
		// 1.读取核心配置文件
		// ApplicationContext是Spring的上下文对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.获取bean对象
		// hello是配置好的bean标签的id值
		Hello hi = (Hello) ac.getBean("hello");
		Hello hi2 = ac.getBean(Hello.class);
		System.out.println(hi);// 地址值
		System.out.println(hi2);
//		hi.hi();
//		hi2.hi();
		System.out.println(hi == hi2);
	}
}
