package com.amac.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 删除业务接口
 * @author qianP
 */
public interface DeleteService {
    JSONObject logicDeleteOrg(Integer[] ids);

    JSONObject physicDeleteOrg(Integer[] ids);
}
