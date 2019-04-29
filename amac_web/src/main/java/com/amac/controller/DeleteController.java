package com.amac.controller;

import com.alibaba.fastjson.JSONObject;
import com.amac.service.DeleteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 删
 * @author qianP
 */
@Controller
@Api(value = "增加功能的接口")
public class DeleteController {

    @Autowired
    DeleteService deleteService;

    @ApiOperation("逻辑删除")
    @GetMapping("/logicDeleteOrg")
    @ResponseBody
    public JSONObject logicDeleteOrg(Integer...ids){
        return deleteService.logicDeleteOrg(ids);
    }

    @ApiOperation("物理删除")
    @GetMapping("/physicDeleteOrg")
    @ResponseBody
    public JSONObject physicDeleteOrg(Integer...ids){
        return deleteService.physicDeleteOrg(ids);
    }
}
