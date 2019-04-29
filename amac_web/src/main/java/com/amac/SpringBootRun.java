package com.amac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author qianP
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.amac.mapper")
public class SpringBootRun {

    public static void main(String[] args){
        SpringApplication.run(SpringBootRun.class,args);
    }

}
