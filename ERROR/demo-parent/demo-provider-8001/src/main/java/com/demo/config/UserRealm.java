package com.demo.config;/*
package com.demo.config;



import com.demo.pojo.User;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


*/
/**
 * 自定义Realm
 * @author Acer
 *特点：继承一个 AuthorizingRealm
 *//*

@Component
public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	UserService userService;
	
	*/
/**
	 * 执行授权逻辑
	 *//*

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		
		// 给资源授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		// 添加资源的授权字符串，必须和前面的perms 一致
		// info.addStringPermission("user:add");
		
		// 到数据库查询当前登录用户的授权字符串
		// 获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		
		// 这个是从认证逻辑中的传的第一个参数得来的
		User user = (User) subject.getPrincipal();
		
		User dbUser = userService.findUserById(user.getuId());
		
		info.addStringPermission(dbUser.getPerms());
		
		return info;
	}
	
	*/
/**
	 * 执行认证逻辑
	 *//*

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		// 获取数据库的用户名和密码
		// String username = "lige666";
		
		// String password = "qwer1234";
		
		// 1.判断用户名
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		
		User user = userService.findUserByName(token.getUsername());
		
		if(user == null) {
			
			// 用户名不存在
			return null;// shiro 底层会抛出一个UnknowAccountException

		}
		
		// 2.判断密码(不需要我们来判断)
		// 第一个参数是需要返回给login 方法的一些数据，可以留空 prinicipal
		// 第二个参数就是我们数据库的密码
		// 第三个是shiro的名字，也可以留空
		return new SimpleAuthenticationInfo(user,user.getPassword(), "");
	}
	
	
}
*/
