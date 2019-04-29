package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * 高管信息
 * @author qianP
 */
@TableName("edp_info")
public class EdpInfo {

    /**
     * 主键对应组织机构id
     */
    @TableId
    private Integer edpInfoId;

    /**
     * 法定代表人名字
     */
    private String larName;

    /**
     * 工作履历
     */
    private Integer jobDetailId;

    /**
     * 员工id
     */
    private Integer empId;

    /**
     * 工作履历
     */
    private List<JobDetail> jobDetailList;
}
