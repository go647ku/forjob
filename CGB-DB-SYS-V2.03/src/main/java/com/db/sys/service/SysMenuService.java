package com.db.sys.service;
import java.util.List;
import java.util.Map;

import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;
/**
 * 菜单管理的业务层接口
 * @author tarena
 */
public interface SysMenuService {
	/**
	 * 更新菜单信息到数据库
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
	/**
	 * 保存菜单信息到数据库
	 * @param entity
	 * @return
	 */
	int saveObject(SysMenu entity);
	
	List<Node> findZtreeMenuNodes();
	/**
	 * 基于菜单id删除菜单以及菜单与角色关系数据
	 * @param id 菜单id
	 * @return 删除的行数
	 */
	int deleteObject(Integer id);
     /**
      * 查询所有菜单信息以及本菜单对应
      * 的上级菜单的名字
      * @return
      */
	 List<Map<String,Object>> findObjects();
}
