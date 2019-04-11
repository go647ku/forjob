package com.jt.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.Transaction;

public class RedisTest {
	
	/**
	 * 1.通过ip和端口可以连接redis
	 * 2.操作的方法就是命令
	 * @throws InterruptedException 
	 */
	@Test
	public void  StringTest() throws InterruptedException {
		Jedis jedis = new Jedis("192.168.140.131", 6379);
		String result = jedis.set("1811","今天周四了");
		//指定超时时间
		jedis.expire("1811",20);
		Thread.sleep(3000);
		Long time = jedis.ttl("1811");
		jedis.persist("1811");
		System.out.println("还能存活:"+time);
		
		System.out.println("保存后的返回值"+result);
		System.out.println("获取值"+jedis.get("1811"));
		
	}
	
	
	@Test
	public void testHash() {
		Jedis jedis = new Jedis("192.168.140.131", 6379);
		jedis.hset("dog", "name", "柯基");
		jedis.hset("dog", "age", "7");
		Map<String, String> map = jedis.hgetAll("dog");
		System.out.println(map);
	}
	
	
	
	/**
	 * 操作list集合,改数据类型,不能长期保存数据
	 * 
	 */
	@Test
	public void testList() {
		Jedis jedis = new Jedis("192.168.140.131", 6379);
//		Long rpush = jedis.rpush("list", "1","2","3","4","5");
//		String rpop = jedis.rpop("list");
//		String lpop = jedis.lpop("list");
//		System.out.println(rpop);
//		System.out.println(lpop);
		Long lpush = jedis.lpush("list", "1","2","3","4","5");
		String rpop = jedis.rpop("list");
		String lpop = jedis.lpop("list");
		System.out.println(rpop);
		System.out.println(lpop);
	}
	
	
	@Test 
	public void tx() {
		Jedis jedis = new Jedis("192.168.140.131", 6379);
		Transaction multi = jedis.multi();
		try {
			multi.set("kk", "kk");
			multi.set("ww", "ww");
			int a=1/0;
			multi.exec();
			
		}catch(Exception e) {
			e.printStackTrace();
			multi.discard();
		}
		
	}
	
	
	
	
	/**
	 * 参数说明
	 * 1.masterName 主机的变量名称
	 * 2.sentinels 哨兵的信息
	 * 
	 */
	@Test
	public void testSentinel() {
		Set<String> sentinels=new HashSet<>();
		sentinels.add("192.168.140.131:26379");
		JedisSentinelPool pool=new JedisSentinelPool("mymaster",sentinels);
		Jedis jedis= pool.getResource();
		jedis.set("aaaaa", "aabbcc");
		System.out.println(jedis.get("aaaaa"));
		jedis.close();
	}
	
	
	@Test
	public void testRedisCluster() {
		String host="192.168.220.132";
		Set<HostAndPort> nodes=new HashSet<>();
		nodes.add(new HostAndPort(host,7000));
		nodes.add(new HostAndPort(host,7001));
		nodes.add(new HostAndPort(host,7002));
		nodes.add(new HostAndPort(host,7003));
		nodes.add(new HostAndPort(host,7004));
		nodes.add(new HostAndPort(host,7005));
		nodes.add(new HostAndPort(host,7006));
		nodes.add(new HostAndPort(host,7007));
		nodes.add(new HostAndPort(host,7008));
		nodes.add(new HostAndPort(host,7009));
		JedisCluster jedisCluster=new JedisCluster(nodes);
		jedisCluster.set("1811", "redis集群搭建完毕");
		System.out.println("获取数据"+jedisCluster);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
