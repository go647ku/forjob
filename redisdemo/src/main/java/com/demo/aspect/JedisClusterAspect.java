package com.demo.aspect;

import org.apache.ibatis.javassist.compiler.ProceedHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.mapper.UserMapper;

import redis.clients.jedis.JedisCluster;

@Order(1)
@Aspect
@Service
public class JedisClusterAspect {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private JedisCluster JedisCluster;
	
	@Around("@annotation(com.demo.annotation.RequireJedis)")
	public Object jedisCache(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{  
		
		if(JedisCluster.get("userList")==null) {
			
			System.out.println("存入redis");
			
			System.out.println(proceedingJoinPoint.proceed());
			
			JedisCluster.set("userList", (String) proceedingJoinPoint.proceed());
			
			return JedisCluster.get("userList");
			
		}
		
		System.out.println("从redis 中取");
		
		return JedisCluster.get("userList");
		
	}
	
}
