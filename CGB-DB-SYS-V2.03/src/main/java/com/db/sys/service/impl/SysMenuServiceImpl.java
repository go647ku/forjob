package com.db.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.db.common.exception.ServiceException;
import com.db.common.vo.Node;
import com.db.sys.dao.SysMenuDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.entity.SysMenu;
import com.db.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public int updateObject(SysMenu entity) {
		//1.验证参数合法性
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("菜单名不能为空");
		if(StringUtils.isEmpty(entity.getPermission()))
			throw new IllegalArgumentException("权限标识不能为空");
		//...
		//2.保存菜单信息
		int rows=-1;
		try{
			rows=sysMenuDao.updateObject(entity);
		}catch(Error e){//Error系统级错误
			e.printStackTrace();//给运维人员发短信
		}catch(RuntimeException e){
			e.printStackTrace();////给运维人员发短信
			throw new ServiceException("系统维护中..");
		}
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		//3.返回结果
		return rows;
	}
    @Override
    public int saveObject(SysMenu entity) {
    	//1.验证参数合法性
    	if(entity==null)
    	throw new IllegalArgumentException("保存对象不能为空");
    	if(StringUtils.isEmpty(entity.getName()))
    	throw new IllegalArgumentException("菜单名不能为空");
    	if(StringUtils.isEmpty(entity.getPermission()))
    	throw new IllegalArgumentException("权限标识不能为空");
    	//...
    	//2.保存菜单信息
    	int rows=-1;
    	try{
    	rows=sysMenuDao.insertObject(entity);
    	}catch(Error e){//Error系统级错误
    	e.printStackTrace();//给运维人员发短信
    	}catch(RuntimeException e){
    	e.printStackTrace();////给运维人员发短信
    	throw new ServiceException("系统维护中..");
    	}
    	//3.返回结果
    	return rows;
    }

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> nodes=sysMenuDao.findZtreeMenuNodes();
		if(nodes==null||nodes.size()==0)
		throw new ServiceException("没有对应的菜单信息");
		return nodes;
	}
	
	@Override
	public int deleteObject(Integer id) {
		//1.参数合法性校验
		if(id==null||id<1)
		throw new IllegalArgumentException("id值无效");
		//2.执行查询操作(基于id查询是否有子菜单)
		int rowCount=sysMenuDao.getChildCount(id);
		if(rowCount>0)
		throw new ServiceException("请先删除子元素");
		//3.删除菜单自身信息
		int rows=sysMenuDao.deleteObject(id);
		if(rows==0)
		throw new ServiceException("菜单可能已经不存在");
		//4.删除菜单角色关系数据
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//5.返回结果
		return rows;
	}
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> list=
			sysMenuDao.findObjects();
		if(list==null||list.size()==0)
		throw new ServiceException("没有对应的菜单信息");
		return list;
	}

}
