package com.db.common.vo;

import java.util.List;

/**
 * VO:Value Object
 * 借助此对象封装角色修改页面上需要的数据
 */
public class SysRoleMenuVo {
   
	private String name;
	private String note;
	private List<Integer> menuIds;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	
}
