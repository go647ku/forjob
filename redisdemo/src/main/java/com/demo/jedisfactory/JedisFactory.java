package com.demo.jedisfactory;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
@PropertySource("classpath:/properties/redis.properties")
public class JedisFactory {
	
	@Value("${redis.nodes}")
	private String redisNodes;
	
	@Bean
	public JedisCluster getJedisCluster() {
		
		Set<HostAndPort> nodes = new HashSet<>();
		
		String[] rNodes = redisNodes.split(",");
		
		for(String node : rNodes) {
			
			String[] args = node.split(":");
			
			String ip = args[0];
			
			int port = Integer.parseInt(args[1]);
			
			HostAndPort hostAndPort = new HostAndPort(ip, port);
			
			nodes.add(hostAndPort);
 			
		}
		
		return new JedisCluster(nodes);
		
	}
	
}
