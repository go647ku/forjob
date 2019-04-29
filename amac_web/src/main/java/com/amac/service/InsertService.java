package com.amac.service;

import com.alibaba.fastjson.JSONObject;
import com.amac.pojo.LegalAdviceInfo;
import com.amac.pojo.OrgInfo;

/**
 * 增    服务接口
 * @author qianP
 */
public interface InsertService {
    JSONObject insertOrg(OrgInfo orgInfo, LegalAdviceInfo legalAdviceInfo);
}
