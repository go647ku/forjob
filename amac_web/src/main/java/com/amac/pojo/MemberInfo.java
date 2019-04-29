package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 会员信息
 * @author qianP
 */
@TableName("member_info")
public class MemberInfo {

    /**
     * 主键对应机构管理人id
     */
    @TableId
    private Integer memberInfoId;

    /**
     * 是否是会员 0 不是 1 是
     */
    private Integer isMember;

    /**
     * 会员代表
     */
    private String memberPresent;

    /**
     * 会员类型
     */
    private String memeberType;

    /**
     * 入会时间
     */
    private String created;

    public Integer getMemberInfoId() {
        return memberInfoId;
    }

    public void setMemberInfoId(Integer memberInfoId) {
        this.memberInfoId = memberInfoId;
    }

    public Integer getIsMember() {
        return isMember;
    }

    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    public String getMemberPresent() {
        return memberPresent;
    }

    public void setMemberPresent(String memberPresent) {
        this.memberPresent = memberPresent;
    }

    public String getMemeberType() {
        return memeberType;
    }

    public void setMemeberType(String memeberType) {
        this.memeberType = memeberType;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
