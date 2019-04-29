package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 高管情况
 * @author qianP
 */
@TableName("edp_detail")
public class EdpDetail {

    /**
     * 主键对应员工id
     */
    @TableId
    private Integer edpDetailId;

    /**
     * 机构管理人id
     */
    private Integer orgAdminId;

    /**
     * 高管姓名
     */
    private String edpName;

    /**
     * 高管职位
     */
    private String edpJob;

    /**
     * 是否有基金从业资格证 0 没有 1 有
     */
    private Integer isSac;

    /**
     * 获取基金从业资格证方式
     */
    private String getFun;

    public Integer getEdpDetailId() {
        return edpDetailId;
    }

    public void setEdpDetailId(Integer edpDetailId) {
        this.edpDetailId = edpDetailId;
    }

    public Integer getOrgAdminId() {
        return orgAdminId;
    }

    public void setOrgAdminId(Integer orgAdminId) {
        this.orgAdminId = orgAdminId;
    }

    public String getEdpName() {
        return edpName;
    }

    public void setEdpName(String edpName) {
        this.edpName = edpName;
    }

    public String getEdpJob() {
        return edpJob;
    }

    public void setEdpJob(String edpJob) {
        this.edpJob = edpJob;
    }

    public Integer getIsSac() {
        return isSac;
    }

    public void setIsSac(Integer isSac) {
        this.isSac = isSac;
    }

    public String getGetFun() {
        return getFun;
    }

    public void setGetFun(String getFun) {
        this.getFun = getFun;
    }
}
