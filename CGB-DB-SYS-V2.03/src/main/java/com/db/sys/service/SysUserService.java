package com.db.sys.service;

import java.util.Map;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptResult;

public interface SysUserService {
	/**
	 * 修改密码
	 * @param password
	 * @param newPassword
	 * @param cfgPassword
	 * @return
	 */
	int updatePassword(String password,
			           String newPassword,
			           String cfgPassword);
	
	/**
	 * 修改用户信息
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity,Integer[] roleIds);
	/**
	 * 基于用于id查询
	 * 1)用户以及对应的部门信息
	 * 2)用户对应的角色信息
	 * @param userId
	 * @return 将两次查询结果封装到map对象
	 */
	Map<String, Object> findObjectById(
			Integer userId);
	
	 /**
	  * 保存用户以及对应的角色信息
	  * @param entity 用户对象
	  * @param roleIds 角色id
	  * @return
	  */
	 int saveObject(SysUser entity,Integer[] roleIds);
	 /**
	  * 禁用或启用用户
	  * @param id 用户id
	  * @param valid 状态值
	  * @param modifiedUser
	  * @return
	  */
	 int validById(Integer id,Integer valid,String modifiedUser);

	 PageObject<SysUserDeptResult> 
	     doFindPageObjects(String username,
	    		 Integer pageCurrent);
}
