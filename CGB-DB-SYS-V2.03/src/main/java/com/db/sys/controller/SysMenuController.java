package com.db.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.sys.entity.SysMenu;
import com.db.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {

	 @Autowired
	 private SysMenuService sysMenuService;
	 
	 @RequestMapping("doMenuEditUI")
	 public String doMenuEditUI(){
		 return "sys/menu_edit";
	 }
	 @RequestMapping("doMenuListUI")
	 public String doMenuListUI(){
		 return "sys/menu_list";
	 }


	 @PostMapping("doUpdateObject")
	 @ResponseBody
	 public JsonResult doUpdateObject(SysMenu entity){
		 sysMenuService.updateObject(entity);
		 return new JsonResult("update ok");
	 }
	 
	 @PostMapping("doSaveObject")
	 @ResponseBody
	 public JsonResult doSaveObject(SysMenu entity){
		 sysMenuService.saveObject(entity);
		 return new JsonResult("save ok");
	 }
	 
	 @RequestMapping("doFindZtreeMenuNodes")
	 @ResponseBody
	 public JsonResult doFindZtreeMenuNodes(){
		 return new JsonResult(
		 sysMenuService.findZtreeMenuNodes());
	 }
	 
	 @RequestMapping("doDeleteObject")
	 @ResponseBody
	 public JsonResult doDeleteObject(Integer id){
		 sysMenuService.deleteObject(id);
		 return new JsonResult("delete ok");
	 }
	 
	 @RequestMapping("doFindObjects")
	 @ResponseBody
	 public JsonResult doFindObjects(){
		 return new JsonResult(
		 sysMenuService.findObjects());
	 }
	 
}






