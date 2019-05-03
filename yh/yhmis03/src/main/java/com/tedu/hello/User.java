package com.tedu.hello;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 这个类用来测试di
 * di: 属性的依赖注入
 */
public class User {
	private String name;
	private Integer age;
	
	// 集合属性
	private List list;
	private Map map;
	private Set set;
	private Properties dbprop;
	
	// 对象属性
	// 一对1，而List的话就是一对多
	private UserInfo Info;
	
	// setters and getters
	
	
	public String getName() {
		return name;
	}
	public UserInfo getInfo() {
		return Info;
	}
	public void setInfo(UserInfo info) {
		Info = info;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Properties getDbprop() {
		return dbprop;
	}
	public void setDbprop(Properties dbprop) {
		this.dbprop = dbprop;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", list=" + list + ", map=" + map + ", set=" + set + ", dbprop="
				+ dbprop + ", Info=" + Info + "]";
	}
	
}
