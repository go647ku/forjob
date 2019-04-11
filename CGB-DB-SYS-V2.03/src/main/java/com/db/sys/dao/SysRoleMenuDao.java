package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 此DAO对象对应sys_role_menus表中数据操作,
 * 此表中存储的是角色和菜单的关系数据.
 */
public interface SysRoleMenuDao {
	/**
	 * 基于角色id获取对应的菜单id
	 * @param roleIds
	 * @return
	 */
	List<Integer> findMenuIdsByRoleIds(
			@Param("roleIds")Integer[] roleIds);
	/**
	 * 基于角色id删除角色与菜单的关系数据
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);
	/**
	 * 保存角色和菜单的关系数据
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	int insertObjects(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	/**
	 * 基于菜单id删除角色和菜单的关系数据
	 * @param menuId 菜单id
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
}
