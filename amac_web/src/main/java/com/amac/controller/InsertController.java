package com.amac.controller;

import com.alibaba.fastjson.JSONObject;
import com.amac.pojo.LegalAdviceInfo;
import com.amac.pojo.OrgInfo;
import com.amac.service.InsertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 增
 * @author qianP
 */
@Controller
@Api(value = "增加功能的接口")
public class InsertController {

    @Autowired
    private InsertService insertService;

    /**
     * 增加机构
     * @param orgInfo
     * @return
     */
    @ApiOperation("插入机构")
    @GetMapping("/insertOrg")
    @ResponseBody
    public JSONObject insertOrg(@ApiParam(value = "插入的组织机构信息对象")OrgInfo orgInfo,
                                @ApiParam(value = "插入的法律意见书信息对象")LegalAdviceInfo legalAdviceInfo){
        return insertService.insertOrg(orgInfo,legalAdviceInfo);
    }
}
