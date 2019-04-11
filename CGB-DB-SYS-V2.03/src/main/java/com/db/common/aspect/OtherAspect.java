package com.db.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(2)
@Aspect
@Service
public class OtherAspect {
	  /**
	   * @Pointcut 注解用于定义切入点表达式
	   */
	  @Pointcut("bean(sysUserServiceImpl)")
	  public void pointCut(){}
	  //通过引用@Pointcut修饰的方法来使用切入点表达式
	  @Before("pointCut()")
	  public void beforeMethod(JoinPoint jp){
		  System.out.println("@Before");
	  }
	  @After("pointCut()")
	  public void afterMethod(){
		  System.out.println("@After");
	  }
	  @AfterReturning("pointCut()")
	  public void returnMethod(){
		  System.out.println("@AfterReturning");
	  }
	  @AfterThrowing("pointCut()")
	  public void throwMethod(){
		  System.out.println("@AfterThrowing");
	  }
	  @Around("pointCut()")
	  public Object aroundMethod(ProceedingJoinPoint jp)
	  throws Throwable{
		  System.out.println("@Around before");
		  Object result=jp.proceed();
		  System.out.println("@Around after");
	      return result;
	  }

}
