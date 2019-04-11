package com.db.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.db.common.exception.ServiceException;
import com.db.common.util.PageUtils;
import com.db.common.vo.CheckBox;
import com.db.common.vo.PageObject;
import com.db.common.vo.SysRoleMenuVo;
import com.db.sys.dao.SysRoleDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.entity.SysRole;
import com.db.sys.service.SysRoleService;

@Service  //NoSuchBeanDefinitionException
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public List<CheckBox> findObjects() {
		List<CheckBox> list=sysRoleDao.findObjects();
		if(list==null||list.size()==0)
		throw new ServiceException("没有对应的角色信息");
		return list;
	}
	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		if(id==null||id<1)
		throw new IllegalArgumentException("id值无效");
		SysRoleMenuVo rm=sysRoleDao.findObjectById(id);
		if(rm==null)
		throw new ServiceException("记录可能已经不存在");
		return rm;
	}
	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		//1.对参数进行校验
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
			throw new ServiceException("必须为角色指定权限");
		//2.保存角色自身信息
		System.out.println("entity.id="+entity.getId());
		int rows=sysRoleDao.updateObject(entity);
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		//3.保存角色菜单关系数据
		//3.1删除原先关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		//3.2添加新的关系数据
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		//4.返回结果
		return rows;
	}
	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		//1.对参数进行校验
		if(entity==null)
		throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
	    throw new IllegalArgumentException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
		throw new ServiceException("必须为角色指定权限");
		//2.保存角色自身信息
		int rows=sysRoleDao.insertObject(entity);
		//3.保存角色菜单关系数据
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		//4.返回结果
		return rows;
	}
	
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		//1.验证参数有效性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("参数无效");
		//2.查询总记录数并进行验证
		int rowCount=sysRoleDao.getRowCount(name);
		if(rowCount==0)
		throw new ServiceException("没有对应记录");
		//3.查询当前页的角色信息
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=sysRoleDao.findPageObjects(name,
				startIndex, pageSize);
		//4.封装查询结果并返回
		return PageUtils.newPageObject(
	    rowCount,records, pageSize, pageCurrent);

	}
}








