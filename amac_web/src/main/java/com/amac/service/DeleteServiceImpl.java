package com.amac.service;

import com.alibaba.fastjson.JSONObject;
import com.amac.mapper.OrgInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 删除业务
 * @author qianP
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeleteServiceImpl implements DeleteService {

    @Autowired
    private OrgInfoMapper orgInfoMapper;


    @Override
    public JSONObject logicDeleteOrg(Integer... ids) {

        Map<String,Object> jsonMap = new HashMap<>();

        try{
            orgInfoMapper.logicDeleteByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put("deleteOrg","逻辑删除失败");
            return new JSONObject(jsonMap);
        }
        jsonMap.put("deleteOrg","逻辑删除成功");
        return new JSONObject(jsonMap);
    }

    @Override
    public JSONObject physicDeleteOrg(Integer[] ids) {

        Map<String,Object> jsonMap = new HashMap<>();

        try{
            orgInfoMapper.physicDeleteByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put("deleteOrg","物理删除失败");
            return new JSONObject(jsonMap);
        }
        jsonMap.put("deleteOrg","物理删除成功");
        return new JSONObject(jsonMap);

    }
}
