package com.db.common.config;

import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan("com.db.**.dao")//扫描指定包中dao
public class AppMyBatisConfig {
      @Bean("sqlSessionFactory")
	  public SqlSessionFactoryBean newSqlSessionFactoryBean(
			 @Autowired DataSource dataSource)throws IOException{
    	  SqlSessionFactoryBean ssf=
    			new SqlSessionFactoryBean();
    	  ssf.setDataSource(dataSource);
    	  Resource[] rs=new PathMatchingResourcePatternResolver()
    	  .getResources("classpath*:mapper/sys/*Mapper.xml");
    	  ssf.setMapperLocations(rs);
		  return ssf;
	  }
}