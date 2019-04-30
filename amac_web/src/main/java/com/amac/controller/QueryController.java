package com.amac.controller;

import com.alibaba.fastjson.JSONObject;
import com.amac.pojo.OrgInfo;
import com.amac.service.QueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 查询功能接口
 * @author qianP
 */
@Api("查询功能接口api")
@Controller
public class QueryController {

    @Autowired
    private QueryService queryService;

    @ApiOperation("查询机构")
    @GetMapping("/doQuery")
    @ResponseBody
    public List<OrgInfo> doQuery(@ApiParam("插入机构的id可变长度数组") Integer... id){
        return queryService.doQueryById(id);
    }

}
