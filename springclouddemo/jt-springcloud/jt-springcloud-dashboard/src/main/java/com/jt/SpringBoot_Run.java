package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableHystrixDashboard
public class SpringBoot_Run {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBoot_Run.class, args);
		
	}
	
}