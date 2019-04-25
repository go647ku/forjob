package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.demo.mapper")
@EnableEurekaClient
@EnableHystrix
@EnableSwagger2
public class SpringBoot_Run {

    public static void main(String[] args){

        SpringApplication.run(SpringBoot_Run.class,args);

    }

}
