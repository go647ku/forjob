package com.db.common.web;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.db.common.vo.JsonResult;
/**
 * @ControllerAdvice 注解描述的类
 * 为一个全局异常处理类,在此类中可以
 * 定义具体的异常处理方法处理相关异常
 * 
 * 其中@RestControllerAdvice
 * 等同于@ControllerAdvice+@ResponseBody
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ShiroException.class)
	public JsonResult doHandleShiroException(
			ShiroException e){
		e.printStackTrace();
		JsonResult r=new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException){
			r.setMessage("账户不存在");
		}else if(e instanceof LockedAccountException){
			r.setMessage("账户被锁定");
		}else if(e instanceof CredentialsException){
			r.setMessage("密码不正确");
		}else if(e instanceof AuthorizationException){
			r.setMessage("没有此操作权限");
		}else {
		    r.setMessage("认证或授权失败");
		}
		return r;
	}
	
   /*@ExceptionHandler(ServiceException.class)
	 @ResponseBody
	 public JsonResult doHandleServiceException(
			 ServiceException e){
	    	e.printStackTrace();
			return new JsonResult(e);
	 }*/
	/**
	 * @ExceptionHandler 注解描述的方法为一个
	 * 异常处理方法
	 * @param e
	 * @return
	 */
    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(
			RuntimeException e){
    	e.printStackTrace();
		return new JsonResult(e);
	}
}





