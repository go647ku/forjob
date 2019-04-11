package com.jt.manage.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.jt.common.annotation.CacheAnno;
import com.jt.common.annotation.CacheAnno.CACHE_TYPE;
import com.jt.common.service.RedisService;
import com.jt.common.util.ObjectMapperUtil;

import redis.clients.jedis.JedisCluster;

@Component
@Aspect
public class CacheAspect {
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@Around("@annotation(cacheAnno)")
	public Object around(ProceedingJoinPoint joinPoint,CacheAnno cacheAnno) throws Exception {
		
		return getObject(joinPoint,cacheAnno);
	}
	
	public Object getObject(ProceedingJoinPoint joinPoint, CacheAnno cacheAnno) throws Exception {
		//获取参数
		
		CACHE_TYPE cacheType = cacheAnno.cacheType();
		
		String 	key = cacheAnno.key();
		int index = cacheAnno.index();
		
		Class<?> targetClass = cacheAnno.targetClass();
		//根据位置获取参数
		Long id = (Long) joinPoint.getArgs()[index];
		System.out.println(id);
		//拼接参数 ITEM_CAT_0
		String redisKey = key + id;
		Object object = null;
		switch (cacheType) {
			case FIND:		//表示查询缓存
				object = findObject(joinPoint,redisKey,targetClass);
				break;
			case UPDATE:	//表示更新缓存
				object = updateObject(joinPoint,redisKey);
				break;
			}
		
		return object;
	}

	private Object findObject(ProceedingJoinPoint joinPoint, String key, Class<?> targetClass) throws Exception {
		
		//检查缓存中是否有数据
		String result = jedisCluster.get(key);
		Object object = null;
		try {
			if(StringUtils.isEmpty(result)) {
				//表示缓存中没有数据,则查询数据库
				object = joinPoint.proceed();
				String json = ObjectMapperUtil.toJson(object);
				jedisCluster.set(key, json);
				System.out.println("AOP查询真实数据库!!");
			}else {
				//表示缓存中有数据,查询缓存
				object = ObjectMapperUtil.toObject(result, targetClass);
				System.out.println("AOP查询缓存!!");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return object;
	}
	
	private Object updateObject(ProceedingJoinPoint joinPoint, String redisKey) {
		//更新缓存,删除即可
		Object object = null;
		try {
			jedisCluster.del(redisKey);
			object = joinPoint.proceed();
			System.out.println("AOP缓存删除");
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return object;
	}
}