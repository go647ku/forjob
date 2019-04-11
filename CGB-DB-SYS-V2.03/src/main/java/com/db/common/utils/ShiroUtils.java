package com.db.common.utils;

import org.apache.shiro.SecurityUtils;

import com.db.sys.entity.SysUser;

public class ShiroUtils {

	 public static SysUser getUser(){
		 return (SysUser)SecurityUtils
		.getSubject().getPrincipal();
	 }
}
