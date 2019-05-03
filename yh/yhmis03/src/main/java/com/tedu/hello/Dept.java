package com.tedu.hello;
/**
 * 这个类用来测试构造方法di(用构造方法进行di)
 */
public class Dept {
	
	private Integer id;
	private String deptName;
	
	// 创建构造方法，完成初始化
	// 和类名相同的叫构造方法:主要是完成对象的初始化
	public Dept(Integer id,String deptName){
		this.id = id;
		this.deptName = deptName;
	}
	
	// setters and getters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	// toString
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + "]";
	}
}
