package com.jt.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@MapperScan(value="com.jt.springcloud.mapper")
@SpringBootApplication
@EnableEurekaClient // 开启注册中心的客户端服务
@EnableHystrix	// 开启断路器机制
public class SpringBoot_Run {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBoot_Run.class, args);
		
	}

}
