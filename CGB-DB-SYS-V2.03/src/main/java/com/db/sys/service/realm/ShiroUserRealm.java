package com.db.sys.service.realm;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.db.sys.dao.SysMenuDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.dao.SysUserDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysUser;
/**
 * Realm只负责数据获取以及基本业务操作
 */
@Service
public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 通过此方法指定凭证匹配器(加密算法)
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//构建凭证匹配对象
		HashedCredentialsMatcher cMatcher=
		new HashedCredentialsMatcher();
		//设置加密算法
		cMatcher.setHashAlgorithmName("MD5");
		//设置加密次数
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}
	/**
	 * 基于此方法完成认证信息的获取以及封装
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
	   AuthenticationToken token) throws AuthenticationException {
		//1.获取客户端输入的用户信息
		UsernamePasswordToken uToken=
		(UsernamePasswordToken)token;
		String username=uToken.getUsername();
		//2.基于用户名查找用户信息
		SysUser user=
		sysUserDao.findUserByUserName(username);
		//3.判定用户是否存在
		if(user==null)
		throw new UnknownAccountException();
		//4.判定用户是否已被禁用
		if(user.getValid()==0)
		throw new LockedAccountException();
		//5.封装用户信息并返回(传递给认证管理器完成认证操作).
		//5.1 封装盐值信息
		ByteSource credentialsSalt=
		ByteSource.Util.bytes(user.getSalt());
		//5.2封装认证信息
		SimpleAuthenticationInfo info=
		new SimpleAuthenticationInfo(
				user,//principal 代表身份信息
				user.getPassword(),//hashedCredentials 已加密的密码
				credentialsSalt,//credentialsSalt 凭证盐值
				getName());//realm 的名字
		return info;
	}
	/**
	 * 基于此方法完成用户权限信息的获取及封装
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//1.获取登录的用户信息
		SysUser user=(SysUser)principals.getPrimaryPrincipal();
		System.out.println("===doGetAuthorizationInfo==");
		//2.基于用户id查询用户对应的角色信息。
		List<Integer> roleIds=
		sysUserRoleDao.findRoleIdsByUserId(user.getId());
		if(roleIds==null||roleIds.size()==0)
		throw new AuthorizationException();
		//3.基于角色id获取菜单id
		Integer array[]={};
		List<Integer> menuIds=
		sysRoleMenuDao.findMenuIdsByRoleIds(
		roleIds.toArray(array));
		if(menuIds==null||menuIds.size()==0)
		throw new AuthorizationException();
		//4.基于菜单id获取菜单对应的权限标识
		List<String> permissions=
		sysMenuDao.findPermissions(menuIds.toArray(array));
		if(permissions==null||permissions.size()==0)
		throw new AuthorizationException();
		//5.对权限信息进行封装并返回。
		Set<String> stringPermissions=new HashSet<>();
		for(String per:permissions){
			if(!StringUtils.isEmpty(per)){
				stringPermissions.add(per);
			}
		}
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.setStringPermissions(stringPermissions);
		return info;
	}


}










