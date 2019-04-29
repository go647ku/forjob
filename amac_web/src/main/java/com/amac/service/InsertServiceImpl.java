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
 * 增    服务实现类
 * @author qianP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InsertServiceImpl implements InsertService{

    @Autowired
    private OrgInfoMapper orgInfoMapper;

    @Autowired
    private LegalAdviceInfoMapper legalAdviceInfoMapper;

    @Override
    public JSONObject insertOrg(OrgInfo orgInfo, LegalAdviceInfo legalAdviceInfo) {

        Map<String,Object> jsonMap = new HashMap<>();

        try{
            orgInfoMapper.insert(orgInfo);
            legalAdviceInfoMapper.insert(legalAdviceInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put("结果","插入失败");
            return new JSONObject(jsonMap);
        }
        jsonMap.put("结果","新增失败");
        return new JSONObject(jsonMap);
    }

    /**
     *  Map<String,Object> jsonMap = new HashMap<>();
     *         jsonMap.put("orgInfo",orgInfo);
     *         return new JSONObject(jsonMap).toJSONString();
     */
}
