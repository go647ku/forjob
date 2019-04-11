package com.db.common.config;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 使用@Configuration 注解描述的类我们可以看成一个
 * 配置类，在此类中可以做一些等效于spring xml配置
 * 中bean对象的配置。
 */
@Configuration //此注解运行时等效于@Service,@Controller,...
@PropertySource("classpath:configs.properties")
public class AppDataSourceConfig {
	/**
	 * 初始化datasource对象，并交给spring框架管理
	 * @Bean 用于描述Bean对象(一般为第三方bean)
	 * @param en 为spring中的一个环境对象，可以存储
	 * 一些配置信息，而我们使用@PropertySource注解
	 * 关联的配置文件中的信息可以存储到Environment对象
	 * @return
	 */
	@Lazy(true)
	@Bean(value="dataSource",
	initMethod="init",destroyMethod="close")  //<bean id="" class="">
	public DataSource newDruidDataSource(
			Environment en){
		//对象应用时：编译时看等号左侧类型，运行时看等号右侧类型
		DruidDataSource d=new DruidDataSource();
		d.setDriverClassName(en.getProperty("jdbcDriver"));
		d.setUrl(en.getProperty("jdbcUrl"));
		d.setUsername(en.getProperty("jdbcUser"));
		d.setPassword(en.getProperty("jdbcPassword"));
	    return d;
	}
}







