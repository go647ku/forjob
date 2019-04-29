package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * 私募基金公示信息
 * @author qianP
 */
@TableName("pef_public_info")
public class PefPublicInfo {

    /**
     * 主键
     */
    @TableId
    private Integer pefPublicInfoId;

    /**
     * 机构管理人id
     */
    private Integer orgAdminId;

    /**
     * 基金编号
     */
    private String funId;

    /**
     * 基金名字
     */
    private String funName;

    /**
     * 成立时间
     */
    private String created;

    /**
     * 二维码地址
     */
    private String funPicPath;

    /**
     * 备案时间
     */
    private String updated;

    /**
     * 基金备案阶段
     */
    private String funUpStage;

    /**
     * 币种
     */
    private String currencyType;

    /**
     * 管理类型
     */
    private String manageType;

    /**
     * 托管人名称
     */
    private String manageName;

    /**
     * 运作状态
     */
    private String workStatus;

    /**
     * 基金信息最后更新时间
     */
    private String lastUpdated;

    /**
     * 基金协会特别提示(针对基金)
     */
    private String funAssoAdvice;

    /**
     * 暂行方法执行前后 0前 1后
     */
    private Integer symbol;
    /**
     * 信息披露情况集合
     */
    private List<InfoPublic> infoPublicList;

    public Integer getPefPublicInfoId() {
        return pefPublicInfoId;
    }

    public void setPefPublicInfoId(Integer pefPublicInfoId) {
        this.pefPublicInfoId = pefPublicInfoId;
    }

    public Integer getOrgAdminId() {
        return orgAdminId;
    }

    public void setOrgAdminId(Integer orgAdminId) {
        this.orgAdminId = orgAdminId;
    }

    public String getFunId() {
        return funId;
    }

    public void setFunId(String funId) {
        this.funId = funId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getFunPicPath() {
        return funPicPath;
    }

    public void setFunPicPath(String funPicPath) {
        this.funPicPath = funPicPath;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getFunUpStage() {
        return funUpStage;
    }

    public void setFunUpStage(String funUpStage) {
        this.funUpStage = funUpStage;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getFunAssoAdvice() {
        return funAssoAdvice;
    }

    public void setFunAssoAdvice(String funAssoAdvice) {
        this.funAssoAdvice = funAssoAdvice;
    }

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public List<InfoPublic> getInfoPublicList() {
        return infoPublicList;
    }

    public void setInfoPublicList(List<InfoPublic> infoPublicList) {
        this.infoPublicList = infoPublicList;
    }
}
