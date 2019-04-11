package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.service.ItemService;
import com.jt.manage.pojo.Item;

//定义类名时，考虑spring容器中是否有该key 如果没有才使用
@RestController
@RequestMapping("/web/item")
public class WebItemController {
	@Autowired
	private ItemService itemService;
		//定义查询的方法路径
		// http://www.jt.com/web/item/findItemById/XXXX
	@RequestMapping("/findItemById/{itemId}")
	public Item findItemById(@PathVariable Long itemId) {
		return itemService.findItemById(itemId);
	}
	
	@RequestMapping("/findItemDescById/{itemId}")
	public ItemDesc findItemDescById(@PathVariable Long itemId) {
		return itemService.findItemDescById(itemId);
	}
}
