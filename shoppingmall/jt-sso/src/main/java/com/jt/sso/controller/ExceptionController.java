package com.jt.sso.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jt.sso.exception.GlobalException;
import com.jt.sso.vo.SysResult;

/**
 *  	全局异常处理层
 * @author Acer
 *
 */

// 统一的异常类进行处理(把默认的异常返回信息改成自定义的异常返回信息)
// 当GlobalContrller抛出HospitalException异常时，将自动找到此类中对应的方法执行，并返回json数据给前台
@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = GlobalException.class) // 异常处理器，处理GlobalException异常
	public SysResult handlerException(HttpServletRequest request, GlobalException globalException) {
		
		return SysResult.build(201, globalException.getMessage());
		
	}
	
}
