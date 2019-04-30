package com.amac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制页面跳转
 * @author qianP
 */
@Api("页面跳转接口")
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/do")
    public String index(){
        return "index";
    }

    /**
     * 增加功能的页面跳转
     * @return
     */
    @ApiOperation(value = "跳转至新增页面insert.html")
    @RequestMapping("/doInsert")
    public String doAdd(){
        return "/function/insert";
    }

    /**
     * 修改功能的页面跳转
     * @return
     */
    @ApiOperation(value = "跳转至修改页面update.html")
    @RequestMapping("/doUpdate")
    public String doUpdate(){
        return "/function/update";
    }
}
