package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 诚信信息详情
 * @author qianP
 */
@TableName("org_honest_info_detail")
public class OrgHonestInfoDetail {

    @TableId
    private Integer orgHonestInfoDetailId;

    private Integer orgHonestInfoId;

    private String adviceType;

    private String adviceDetail;

    public Integer getOrgHonestInfoDetailId() {
        return orgHonestInfoDetailId;
    }

    public void setOrgHonestInfoDetailId(Integer orgHonestInfoDetailId) {
        this.orgHonestInfoDetailId = orgHonestInfoDetailId;
    }

    public Integer getOrgHonestInfoId() {
        return orgHonestInfoId;
    }

    public void setOrgHonestInfoId(Integer orgHonestInfoId) {
        this.orgHonestInfoId = orgHonestInfoId;
    }

    public String getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(String adviceType) {
        this.adviceType = adviceType;
    }

    public String getAdviceDetail() {
        return adviceDetail;
    }

    public void setAdviceDetail(String adviceDetail) {
        this.adviceDetail = adviceDetail;
    }
}
