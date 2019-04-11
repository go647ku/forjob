package com.jt.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan(value="com.jt.springcloud.mapper")
@SpringBootApplication
@EnableEurekaClient
public class SpringBoot_Run {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBoot_Run.class, args);
		
	}

}
