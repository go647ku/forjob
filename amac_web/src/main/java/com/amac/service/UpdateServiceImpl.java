package com.amac.service;

import com.alibaba.fastjson.JSONObject;
import com.amac.mapper.LegalAdviceInfoMapper;
import com.amac.mapper.OrgInfoMapper;
import com.amac.pojo.LegalAdviceInfo;
import com.amac.pojo.OrgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 更新业务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private OrgInfoMapper orgInfoMapper;

    @Autowired
    private LegalAdviceInfoMapper legalAdviceInfoMapper;

    @Override
    public JSONObject doUpdate(OrgInfo orgInfo) {
        Map<String,Object> jsopMap = new HashMap<>();
        try{
            legalAdviceInfoMapper.updateById(orgInfo.getLegalAdviceInfo());
            orgInfo.setLegalAdviceInfo(null);
            orgInfoMapper.updateById(orgInfo);
            jsopMap.put("结果","更新成功");
        }catch (Exception e){
            e.printStackTrace();
            jsopMap.put("结果","更新失败");
        }
        return new JSONObject(jsopMap);
    }
}
