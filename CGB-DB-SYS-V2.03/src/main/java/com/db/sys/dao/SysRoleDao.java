package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.CheckBox;
import com.db.common.vo.SysRoleMenuVo;
import com.db.sys.entity.SysRole;

public interface SysRoleDao {
	/**
	 * 查询角色id和名字
	 * @return
	 */
	List<CheckBox> findObjects();
	/**
	 * 更新角色自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysRole entity);
	
	 /**
	  * 基于角色id查询角色以及对应的菜单信息
	  * @param id
	  * @return
	  */
	 SysRoleMenuVo findObjectById(Integer id);
	  
	 /**
	   * 向角色表中写入角色信息
	   * @param entity
	   * @return
	   */
	  int insertObject(SysRole entity);
	  
	   /**
	    * 基于记录名字获取记录总数
	    * @param name
	    * @return
	    */
	   int getRowCount(@Param("name")String name);
	   /**
	    * 查询当前页要呈现的角色信息
	    * @param name 查询条件:角色名
	    * @param startIndex 起始位置
	    * @param pageSize 页面大小
	    * @return
	    */
	   List<SysRole> findPageObjects(
			   @Param("name")String name,
			   @Param("startIndex")Integer startIndex,
			   @Param("pageSize")Integer pageSize);
	   
}
