package com.amac.service;

import com.alibaba.fastjson.JSONObject;
import com.amac.pojo.LegalAdviceInfo;
import com.amac.pojo.OrgInfo;

/**
 * 更新业务接口
 * @author qianP
 */
public interface UpdateService {

    /**
     * 更新功能
     * @param orgInfo
     * @return
     */
    JSONObject doUpdate(OrgInfo orgInfo);

}
