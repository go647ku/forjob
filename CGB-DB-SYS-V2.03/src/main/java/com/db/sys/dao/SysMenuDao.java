package com.db.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;

public interface SysMenuDao {
	/**
	 * 基于菜单id获取对应的权限标识{"sys:log:delete","sys:user:valid"}
	 * @param menuIds
	 * @return
	 */
	List<String> findPermissions(
			@Param("menuIds")
			Integer[] menuIds);
	/**
	 * 更新菜单数据
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
	/**
	 * 将菜单信息写入到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	/**
	 * 查询菜单id,name,parentid信息
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	 /**
	  * 基于菜单id统计子菜单数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	 /**
	  * 基于菜单id执行菜单自身信息删除操作
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 

	 List<Map<String,Object>> findObjects();
}
