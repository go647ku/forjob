package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 法律意见信息
 * @author qianP
 */
@TableName("legal_advice_info")
public class LegalAdviceInfo {

    /**
     * 主键对应组织机构id
     */
    @TableId
    private Integer legalAdviceInfoId;

    /**
     * 法律意见书状态
     * @return
     */
    private String legalStatus;

    public Integer getLegalAdviceInfoId() {
        return legalAdviceInfoId;
    }

    public void setLegalAdviceInfoId(Integer legalAdviceInfoId) {
        this.legalAdviceInfoId = legalAdviceInfoId;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }
}
