package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.manage.service.ItemCatService;
import com.jt.manage.service.ItemService;
import com.jt.manage.vo.EasyUITree;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
	
	
	/**
	 * @RequestParam(value="接受参数的名称",defaultValue="默认值",required="true 用户必须传值 ，false相反"
	 */
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	public List<EasyUITree> findItemCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		//先查询一级商品分类信息
		//return itemCatService.findCacheItemCat(parentId);
		return itemCatService.findItemCatList(parentId);
	}
}
