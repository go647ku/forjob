package com.jt.web.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;


public class ItemDesc extends BasePojo{


	private Long itemId;
	private String ItemDesc;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	
}
