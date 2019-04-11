package com.jt.sso.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {
	
	// 定义切入点
	@AfterThrowing("@annotation(com.jt.sso.annotation.Erro)")
	public void GlobalError(JoinPoint joinPoint) throws Throwable{
		
		System.out.println("全局异常");
			
	}
	
}
