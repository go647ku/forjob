package com.amac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @ResponseBody
    public String test(){
        return "1";
    }

    /**
     * 增加功能的页面跳转
     * @return
     */
    @ApiOperation(value = "跳转至新增页面insert.html")
    @RequestMapping("/doInsert")
    public String doAdd(){
        return "insert";
    }

}
