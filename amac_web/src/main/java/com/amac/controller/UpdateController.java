package com.amac.controller;

import com.alibaba.fastjson.JSONObject;
import com.amac.pojo.LegalAdviceInfo;
import com.amac.pojo.OrgInfo;
import com.amac.service.UpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 更新功能接口
 * @author qianP
 */
@Controller
@Api("更新功能接口")
public class UpdateController {

    @Autowired
    private UpdateService updateService;

    @ApiOperation("执行更新功能")
    @PostMapping("/doUpdate")
    @ResponseBody
    public JSONObject doUpdate(@RequestBody @ApiParam("获取更新的对象信息")OrgInfo orgInfo){
        return updateService.doUpdate(orgInfo);
    }

}
