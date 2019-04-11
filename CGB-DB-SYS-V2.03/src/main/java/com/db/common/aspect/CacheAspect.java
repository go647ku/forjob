package com.db.common.aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class CacheAspect {
     private Map<CacheKey,Object> cache=
     new ConcurrentHashMap<>();
	 @Around("@annotation(com.db.common.annotation.RequiredCache)")
	 public Object aroundCache(ProceedingJoinPoint jp)
	 throws Throwable{
		 //1.先从缓存取
		 CacheKey key=new CacheKey();
		 Class<?> targetClass=jp.getTarget().getClass();
		 key.setTargetClass(targetClass);
		 MethodSignature ms=(MethodSignature)jp.getSignature();
		 key.setTargetMethod(ms.getMethod());
		 key.setArgs(jp.getArgs());
		 Object result=cache.get(key);
		 //2.缓存没有则执行目标方法
		 if(result==null){
			 result=jp.proceed();
			 //3.将执行目标方法时获取的结果存储到缓存
			 cache.put(key,result);
		 }
		 //4.返回结果
		 return result;
	 }
}
