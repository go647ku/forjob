package com.db.sys.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.db.common.annotation.RequiredCache;
import com.db.common.annotation.RequiredLog;
import com.db.common.exception.ServiceException;
import com.db.common.util.PageUtils;
import com.db.common.vo.PageObject;
import com.db.sys.dao.SysUserDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;
import com.db.sys.vo.SysUserDeptResult;

@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class,timeout=30,isolation=Isolation.READ_COMMITTED)
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	/**
	 * @param password 原密码
	 * @param newPassword 新密码
	 * @param newPassword 确认密码
	 */
	@Override
	public int updatePassword(
			String password,
			String newPassword,
			String cfgPassword) {
		
        //1.对参数进行非空验证
		//2.验证密码的合法性
		//2.1判定两次输入密码是否一致
		if(!newPassword.equals(cfgPassword))
		throw new IllegalArgumentException("两次输入密码不一致");
		//2.2判定输入的原密码是否正确
		SysUser user=(SysUser)SecurityUtils.getSubject().getPrincipal();
		SimpleHash sh=new SimpleHash("MD5",
				password, user.getSalt(), 1);
		if(!user.getPassword().equals(sh.toHex()))
	    throw new IllegalArgumentException("输入的原密码不正确");
	    //2.3判定原密码与新密码是否一致
		if(password.equals(newPassword))
		throw new IllegalArgumentException("新密码不能与原密码相同");
	    //3.更新密码
		String salt=UUID.randomUUID().toString();
		sh=new SimpleHash("MD5",
				newPassword, salt, 1);
		int rows=sysUserDao.updatePassword(
				user.getUsername(),
				sh.toHex(),//已加密的新密码
				salt);
		
		return rows;
	}
	@Transactional(readOnly=true)//默认readOnly=false
	@Override
	public Map<String, Object> findObjectById(Integer userId) {
		
		//1.对参数进行校验
		if(userId==null||userId<1)
		throw new IllegalArgumentException("参数值不合法");
		//2.查询用户以及对应的部门信息
		SysUserDeptResult user=sysUserDao.findObjectById(userId);
		if(user==null)
		throw new ServiceException("记录可能已经不存在");
		//3.查询用户对应的角色id
		List<Integer> roleIds=sysUserRoleDao.findRoleIdsByUserId(userId);
		//4.封装查询结果并返回
		Map<String,Object> map=new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		
		return map;
	}
   
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		
		long t1=System.currentTimeMillis();
		//1.参数有效性验证
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("用户名不能为空");
		if(roleIds==null || roleIds.length==0)
			throw new ServiceException("至少要为用户分配角色");
		//2.保存用户信息
		//2.1将用户信息写入到数据库
		int rows=sysUserDao.updateObject(entity);
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		//2.2.将用户和角色关系数据写入数据库
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		long t2=System.currentTimeMillis();
		long executeTime=t2-t1;
		System.out.println("execute time "+executeTime);
		
		return rows;
	}
	
	@RequiredLog("保存用户")
	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		//1.参数有效性验证
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getPassword()))
			throw new ServiceException("密码不能为空");
		if(roleIds==null || roleIds.length==0)
			throw new ServiceException("至少要为用户分配角色");
		//2.保存用户信息
		//2.1 创建一个盐值(与密码进行一起加密)
		String salt=UUID.randomUUID().toString();
		//2.2对密码进行加密(SimpleHash为shiro框架提供)
		SimpleHash sh=new SimpleHash(
				"MD5", //algorithmName
				 entity.getPassword(),//没有加密的密码
				 salt, 
				 1);//hashIterations 表示加密次数
		String newPwd=sh.toHex();//将密码转换为16进制
		//2.3将salt,newPwd存储entity对象
		entity.setSalt(salt);
		entity.setPassword(newPwd);
		//2.4将用户信息写入到数据库
		int rows=sysUserDao.insertObject(entity);
		//3.将用户和角色关系数据写入数据库
		int count=sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		//if(count>0)//为了掩饰事务
		//throw new ServiceException("save error");
		return rows;
	}
	@RequiredLog("禁用启用")
	@RequiresPermissions("sys:user:valid")
	@Override
	public int validById(Integer id, 
			Integer valid,
			String modifiedUser) {
		//1.合法性验证
		if(id==null||id<=0)
			throw new ServiceException("参数不合法,id="+id);
		if(valid!=1&&valid!=0)
			throw new ServiceException("参数不合法,valie="+valid);
		if(StringUtils.isEmpty(modifiedUser))
			throw new ServiceException("修改用户不能为空");
		//2.执行禁用或启用操作
		int rows=0;
		try{
			rows=sysUserDao.validById(id, valid, modifiedUser);
		}catch(Throwable e){
			e.printStackTrace();
			//报警,给维护人员发短信
			throw new ServiceException("底层正在维护");
		}
		//3.判定结果,并返回
		if(rows==0)
		throw new ServiceException("此记录可能已经不存在");
		return rows;
	}
	@Transactional(readOnly=true)
	@RequiredCache
	@Override
	public PageObject<SysUserDeptResult> doFindPageObjects(String username,
   		 Integer pageCurrent) {
		System.out.println("query from database");
		//1.数据合法性验证
		if(pageCurrent==null||pageCurrent<=0)
		throw new ServiceException("参数不合法");
        //2.依据条件获取总记录数
		int rowCount=sysUserDao.getRowCount(username);
        if(rowCount==0)
		throw new ServiceException("记录不存在");
		//3.计算startIndex的值
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		//4.依据条件获取当前页数据
		List<SysUserDeptResult> records=
			sysUserDao.findPageObjects(
		username, startIndex, pageSize);
		//5.封装数据
		PageObject<SysUserDeptResult> pageObject=
		PageUtils.newPageObject(rowCount,
				records, pageSize, pageCurrent);
		return pageObject;
	}

}
