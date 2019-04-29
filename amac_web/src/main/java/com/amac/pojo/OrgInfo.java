package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * 机构信息
 * @author qianP
 */
@TableName("demo_org_info")
public class OrgInfo {

    /**
     * 机构信息主键   对应  基金管理人id
     */
    @TableId
    private Integer orgInfoId;

    public List<PefPublicInfo> getPefPublicInfoList() {
        return pefPublicInfoList;
    }

    public void setPefPublicInfoList(List<PefPublicInfo> pefPublicInfoList) {
        this.pefPublicInfoList = pefPublicInfoList;
    }

    /**
     * 中文全称
     */
    private String orgAdminCname;

    /**
     * 英文全称
     */
    private String orgAdminEname;

    /**
     * 登记编号
     */
    private String loginId;

    /**
     * 二维码路径
     */
    private String picPath;

    /**
     * 组织机构代码
     */
    private String orgCode;

    /**
     * 成立时间
     */
    private String created;

    /**
     * 登记时间
     */
    private String updated;

    /**
     * 注册地址
     */
    private String registerArea;

    /**
     * 工作地址
     */
    private String workArea;

    /**
     * 上缴资金(万元)
     */
    private Integer handinMoney;

    /**
     * 注册资金(万元)
     */
    private Integer registerMoney;

    /**
     * 注册资本实缴比例
     */
    private String moneyPercent;

    /**
     * 企业性质
     */
    private String companyType;

    /**
     *组织类型
     */
    private String orgType;

    /**
     * 业务类型
     */
    private String busType;

    /**
     * 员工人数
     */
    private Integer empNumber;

    /**
     * 机构网址
     */
    private String orgWeb;

    /**
     * 是否为符合提供投资建议条件的第三方机构 0 不是 1 是
     */
    private Integer isThirdParty;

    /**
     * 机构诚信信息
     */
    private OrgHonestInfo orgHonestInfo;

    /**
     * 会员信息
     */
    private MemberInfo memberInfo;

    /**
     * 法律意见信息
     */
    private LegalAdviceInfo legalAdviceInfo;

    /**
     * 诚信信息
     */
    private HonestInfo honestInfo;

    /**
     * 高管信息
     */
    private EdpInfo edpInfo;

    /**
     * 产品信息表
     */
    private List<PefPublicInfo> pefPublicInfoList;

    public EdpInfo getEdpInfo() {
        return edpInfo;
    }

    public void setEdpInfo(EdpInfo edpInfo) {
        this.edpInfo = edpInfo;
    }

    public List<EdpDetail> getEdpDetailList() {
        return edpDetailList;
    }

    public void setEdpDetailList(List<EdpDetail> edpDetailList) {
        this.edpDetailList = edpDetailList;
    }

    /**
     * 高管情况
     */
    private List<EdpDetail> edpDetailList;

    /**
     * 逻辑删除状态 0 未删  1 已删
     */
    private Integer dStatus;

    public Integer getdStatus() {
        return dStatus;
    }

    public void setdStatus(Integer dStatus) {
        this.dStatus = dStatus;
    }

    public HonestInfo getHonestInfo() {
        return honestInfo;
    }


    public void setHonestInfo(HonestInfo honestInfo) {
        this.honestInfo = honestInfo;
    }

    public LegalAdviceInfo getLegalAdviceInfo() {
        return legalAdviceInfo;
    }

    public void setLegalAdviceInfo(LegalAdviceInfo legalAdviceInfo) {
        this.legalAdviceInfo = legalAdviceInfo;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public Integer getOrgInfoId() {
        return orgInfoId;
    }

    public void setOrgInfoId(Integer orgInfoId) {
        this.orgInfoId = orgInfoId;
    }

    public String getOrgAdminCname() {
        return orgAdminCname;
    }

    public void setOrgAdminCname(String orgAdminCname) {
        this.orgAdminCname = orgAdminCname;
    }

    public String getOrgAdminEname() {
        return orgAdminEname;
    }

    public void setOrgAdminEname(String orgAdminEname) {
        this.orgAdminEname = orgAdminEname;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getRegisterArea() {
        return registerArea;
    }

    public void setRegisterArea(String registerArea) {
        this.registerArea = registerArea;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public Integer getHandinMoney() {
        return handinMoney;
    }

    public void setHandinMoney(Integer handinMoney) {
        this.handinMoney = handinMoney;
    }

    public Integer getRegisterMoney() {
        return registerMoney;
    }

    public void setRegisterMoney(Integer registerMoney) {
        this.registerMoney = registerMoney;
    }

    public String getMoneyPercent() {
        return moneyPercent;
    }

    public void setMoneyPercent(String moneyPercent) {
        this.moneyPercent = moneyPercent;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public String getOrgWeb() {
        return orgWeb;
    }

    public void setOrgWeb(String orgWeb) {
        this.orgWeb = orgWeb;
    }

    public Integer getIsThirdParty() {
        return isThirdParty;
    }

    public void setIsThirdParty(Integer isThirdParty) {
        this.isThirdParty = isThirdParty;
    }

    public OrgHonestInfo getOrgHonestInfo() {
        return orgHonestInfo;
    }

    public void setOrgHonestInfo(OrgHonestInfo orgHonestInfo) {
        this.orgHonestInfo = orgHonestInfo;
    }
}
