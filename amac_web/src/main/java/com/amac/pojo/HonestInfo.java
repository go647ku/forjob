package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 诚信信息
 * @author qianP
 */
@TableName("honest_info")
public class HonestInfo {

    /**
     * 主键，对应组织机构id
     */
    @TableId
    private Integer honestInfoId;

    /**
     * 机构信息最后更新时间
     */
    private String updated;

    /**
     * 特殊建议
     */
    private String sepcialAdvice;

    public Integer getHonestInfoId() {
        return honestInfoId;
    }

    public void setHonestInfoId(Integer honestInfoId) {
        this.honestInfoId = honestInfoId;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSepcialAdvice() {
        return sepcialAdvice;
    }

    public void setSepcialAdvice(String sepcialAdvice) {
        this.sepcialAdvice = sepcialAdvice;
    }
}
