package com.jt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

public class testShards {
	@Test
	public void test01() {
		
		List<JedisShardInfo>  shards=new ArrayList<JedisShardInfo>();
		JedisShardInfo info1=new JedisShardInfo("192.168.140.131",6379);
		JedisShardInfo info2=new JedisShardInfo("192.168.140.131",6380);
		JedisShardInfo info3=new JedisShardInfo("192.168.140.131",6381);
		shards.add(info1);
		shards.add(info2);
		shards.add(info3);
		ShardedJedis jedis=new ShardedJedis(shards);
		jedis.set("1811", "分片测试");
		System.out.println(jedis.get("1811"));
	}
}
