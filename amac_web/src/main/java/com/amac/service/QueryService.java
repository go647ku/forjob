package com.amac.service;

import com.amac.pojo.OrgInfo;

import java.util.List;

/**
 * 查询业务接口
 * @author qianP
 */
public interface QueryService {

    List<OrgInfo> doQueryById(Integer[] id);

}
