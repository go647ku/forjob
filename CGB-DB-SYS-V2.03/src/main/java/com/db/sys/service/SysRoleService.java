package com.db.sys.service;

import java.util.List;

import com.db.common.vo.CheckBox;
import com.db.common.vo.PageObject;
import com.db.common.vo.SysRoleMenuVo;
import com.db.sys.entity.SysRole;

public interface SysRoleService {
	 /**
	 * 查询角色id和名字
	 * @return
	 */
	 List<CheckBox> findObjects();
	
	  /**
	   * 更新角色自身信息以及角色对应的菜单信息
	   * @param entity
	   * @param menuIds
	   * @return
	   */
	int updateObject(SysRole entity,Integer[]menuIds);
	
	
	/**
	 * 基于角色id查询角色以及角色对应的菜单信息
	 * @param id
	 * @return
	 */
	 SysRoleMenuVo findObjectById(Integer id) ;
	
	  /**
	   * 保存角色自身信息以及角色对应的菜单信息
	   * @param entity
	   * @param menuIds
	   * @return
	   */
	  int saveObject(SysRole entity,Integer[]menuIds);
	
      /**
       * 分页查询角色信息
       * @param name
       * @param pageCurrent
       * @return
       */
	  PageObject<SysRole>findPageObjects(
			    String name,
	    		Integer pageCurrent);
}
