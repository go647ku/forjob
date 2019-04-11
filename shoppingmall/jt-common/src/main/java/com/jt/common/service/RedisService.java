package com.jt.common.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisService {
	
	@Autowired(required=false)
	private JedisSentinelPool pool;
	
	public  void set(String key,String value) {
		Jedis jedis = pool.getResource();
		jedis.set(key, value);
		jedis.expire(key, 7*24*3600);
		jedis.close();
		
	}
	
	public  String get(String key) {
		Jedis jedis = pool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}
	
	public void del(String key) {
		Jedis jedis = pool.getResource();
		Long del = jedis.del(key);
		jedis.close();
	}
}
