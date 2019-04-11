package com.jt.web.util;

import com.jt.web.pojo.User;

public class UserThreadLocal {
	
	private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();
	
	public static void set(User user) {
		
		userThreadLocal.set(user);
		
	}
	
	public static User get() {
		
		return userThreadLocal.get();
		
	}
	
	// 使用ThreadLocal切记删除对象，防止内存泄漏,用完了，记得删
	public static void remove() {
		
		userThreadLocal.remove();
		
	}
	
}
