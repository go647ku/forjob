package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.service.ItemService;
import com.jt.manage.vo.EasyUITable;
import com.jt.manage.pojo.Item;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/query")
	@ResponseBody
	public EasyUITable findItemList(int page,int rows) {
		
		return itemService.findItemListByPage(page,rows);
	}
	
	
	
	/**
	 * 1、Object对象类型，返回值编辑就是UTF-8
	 * 2、如果返回值是String类型，返回值的编辑类型就是IOS-8851-1
	 * @param itemCatId
	 * @return
	 */
	//根据商品分类的Id名称查询
	@RequestMapping(value="/cat/queryItemCatNameById",produces="text/html;charset=utf-8")
	@ResponseBody
	public String  findItemCatNameById(Long itemCatId) {
		
		
		return itemService.findItemCatNameById(itemCatId);
		
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public SysResult save(Item item,String desc) {
		
		try {
			itemService.saveItem(item,desc);
			return SysResult.oK();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  SysResult.build(201, "用户新增失败");
		
	}
	
	
	
	@RequestMapping("/instock")
	@ResponseBody
	public SysResult instock(Long[] ids) {
		
		try {
			int status=2;//表示商品下架
			itemService.updateStatus(ids,status);
			
			return SysResult.oK();
		}catch(Exception e){
			e.printStackTrace();
		}
		return SysResult.build(201, "下架失败");
	}
	
	
	
	@RequestMapping("/reshelf")
	@ResponseBody
	public SysResult reshelf(Long[] ids) {
		try {
			int status=1;//表示商品下架
			itemService.updateStatus(ids,status);
		
			return SysResult.oK();
		}catch(Exception e){
			e.printStackTrace();
		}
		return SysResult.build(201, "上架失败");
	}
	
	
	
	
	@RequestMapping("/update")
	@ResponseBody
	public SysResult update(Item item,String desc) {
		
		try {
			itemService.updateItem(item,desc);
			return SysResult.oK();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "修改失败");
	}
	
	
	 @RequestMapping("/delete")
	 @ResponseBody
	 public SysResult delete(Long[] ids){
		 try {
			 itemService.delete(ids);
			// System.out.println(ids.length);
			 return SysResult.oK();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return SysResult.build(201, "删除失败");
		 
	 }
	 
	
	 //实现商品详情查询
	 @RequestMapping("query/item/desc/{itemId}")
	 @ResponseBody
	 public SysResult findItemDescById(@PathVariable("itemId")Long itemId){
		 try {
			 	ItemDesc itemDesc=itemService.findItemDescById(itemId);
			 	return SysResult.oK(itemDesc);
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return SysResult.build(201, "商品查询失败");
		 
	 }
	
	
	
}
