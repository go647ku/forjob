package com.jt.demo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.demo.config.JedisClusterConfig;
import com.jt.demo.mapper.UserMapper;
import com.jt.demo.pojo.User;

import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class) // 启动时加载项目
@SpringBootTest // springboot测试支持
public class TestMybatis {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test01() {
		System.out.println(userMapper.findAll());
	}
	
	// 测试save方法
	@Test
	public void saveUser() {
		User user = new User();
		user.setName("诸葛亮").setAge(8000).setSex("女");
		userMapper.insert(user);
		System.out.println("用户入库成功");
	}
	
	// 测试修改方法
	/**
	 * entity:数据修改的值的之后封装为对象
	 * updateWrapper:条件构造器
	 * 				修改where条件的构造方式
	 * 
	 */
	@Test
	public void updateUser() {
		User user = new User();
		user.setAge(25);
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("name", "大小二乔");
		userMapper.update(user, updateWrapper);
	}
	
	// 要求：将年龄超过8000岁的名字改成老不死的！！
	@Test
	public void updateUser2() {
		User user = new User();
		user.setName("老不死");
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.ge("age", 8000);// 小于是lt，小于等于是后面+.eq
		userMapper.update(user, updateWrapper);
		System.out.println("用户修改完成");
	}
	
	// 要求：删除
	@Test
	public void deleteUser() {
		QueryWrapper<User> queryWrapper = new QueryWrapper();
		queryWrapper.eq("age", 8000);
		userMapper.delete(queryWrapper);
		System.out.print("用户删除成功");
	}
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@Test
	public void testRedis() {
		jedisCluster.set("1811", "芦苇");
	}
	
	@Test
	public void test() {
		
		User user = userMapper.selectById(1);
	}
	
}
