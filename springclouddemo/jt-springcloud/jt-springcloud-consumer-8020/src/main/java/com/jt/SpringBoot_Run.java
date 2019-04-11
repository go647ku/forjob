package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

// 排除数据源的加载项
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
public class SpringBoot_Run {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBoot_Run.class, args);
		
	}
	
}
