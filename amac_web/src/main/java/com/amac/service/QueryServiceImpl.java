package com.amac.service;

import com.amac.mapper.LegalAdviceInfoMapper;
import com.amac.mapper.OrgInfoMapper;
import com.amac.pojo.OrgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 查询业务
 * @author qianP
 */
@Service
public class QueryServiceImpl implements QueryService{

    @Autowired
    private OrgInfoMapper orgInfoMapper;

    @Autowired
    private LegalAdviceInfoMapper legalAdviceInfoMapper;


    @Override
    public List<OrgInfo> doQueryById(Integer[] ids) {
        try{
            List<OrgInfo> orgInfoList = orgInfoMapper.doQueryById(ids);
            for(OrgInfo orgInfo:orgInfoList){
                orgInfo.setLegalAdviceInfo(legalAdviceInfoMapper.selectById(orgInfo.getOrgInfoId()));
            }
            return orgInfoList;
        }catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 异常处理的内容获取机构主键为-1
         */
        OrgInfo orgInfo = new OrgInfo();
        orgInfo.setOrgInfoId(-1);
        List<OrgInfo> orgInfoList = new LinkedList<>();
        orgInfoList.add(orgInfo);
        return orgInfoList;
    }
}
