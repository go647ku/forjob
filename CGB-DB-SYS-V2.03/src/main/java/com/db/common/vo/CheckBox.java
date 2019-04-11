package com.db.common.vo;
import java.io.Serializable;
/**
 * VO:通过此对象封装查询出的角色id和角色名称
 */
public class CheckBox implements Serializable {
	private static final long serialVersionUID = 5127226184862470973L;
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	 
}
