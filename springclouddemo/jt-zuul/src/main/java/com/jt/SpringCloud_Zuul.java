package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableZuulProxy
public class SpringCloud_Zuul {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringCloud_Zuul.class, args);
	}
}
