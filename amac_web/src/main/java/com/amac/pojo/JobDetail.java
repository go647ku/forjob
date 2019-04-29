package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 工作履历
 * @author qianP
 */
@TableName("job_detail")
public class JobDetail {

    /**
     * 主键，无对应关系
     */
    @TableId
    private Integer jobDetailId;

    /**
     * 员工id
     */
    private Integer empId;

    /**
     * 工作时间
     */
    private String jobTime;

    /**
     * 工作单位
     */
    private String jobUnit;

    /**
     * 工作单位
     */
    private String jobDept;

    /**
     * 职位
     */
    private String job;

    /**
     * 机构管理人id
     */
    private Integer orgAdminId;

    public Integer getJobDetailId() {
        return jobDetailId;
    }

    public void setJobDetailId(Integer jobDetailId) {
        this.jobDetailId = jobDetailId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public String getJobUnit() {
        return jobUnit;
    }

    public void setJobUnit(String jobUnit) {
        this.jobUnit = jobUnit;
    }

    public String getJobDept() {
        return jobDept;
    }

    public void setJobDept(String jobDept) {
        this.jobDept = jobDept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getOrgAdminId() {
        return orgAdminId;
    }

    public void setOrgAdminId(Integer orgAdminId) {
        this.orgAdminId = orgAdminId;
    }
}
