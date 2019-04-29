package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * 机构诚信信息
 * @author qianP
 */
@TableName("org_honest_info")
public class OrgHonestInfo {

    /**
     * 对应org_admin_id
     */
    @TableId
    private Integer orgHonestInfoId;

    private List<OrgHonestInfoDetail> orgHonestInfoDetailList;

    public Integer getOrgHonestInfoId() {
        return orgHonestInfoId;
    }

    public void setOrgHonestInfoId(Integer orgHonestInfoId) {
        this.orgHonestInfoId = orgHonestInfoId;
    }

    public List<OrgHonestInfoDetail> getOrgHonestInfoDetailList() {
        return orgHonestInfoDetailList;
    }

    public void setOrgHonestInfoDetailList(List<OrgHonestInfoDetail> orgHonestInfoDetailList) {
        this.orgHonestInfoDetailList = orgHonestInfoDetailList;
    }
}
