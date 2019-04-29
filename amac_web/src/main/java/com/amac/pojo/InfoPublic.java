package com.amac.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 基金信息公示
 * @author qianP
 */
@TableName("info_public")
public class InfoPublic {

    /**
     * 主键
     */
    private Integer infoPublicId;

    /**
     *基金公示id
     */
    private Integer pefPublicInfoId;

    /**
     * 当月月报
     */
    private String currentReport;

    /**
     * 半年报
     */
    private String halfYearReport;

    /**
     * 年报
     */
    private String yearReport;

    /**
     * 季报
     */
    private String seasonReport;

    public Integer getInfoPublicId() {
        return infoPublicId;
    }

    public void setInfoPublicId(Integer infoPublicId) {
        this.infoPublicId = infoPublicId;
    }

    public Integer getPefPublicInfoId() {
        return pefPublicInfoId;
    }

    public void setPefPublicInfoId(Integer pefPublicInfoId) {
        this.pefPublicInfoId = pefPublicInfoId;
    }

    public String getCurrentReport() {
        return currentReport;
    }

    public void setCurrentReport(String currentReport) {
        this.currentReport = currentReport;
    }

    public String getHalfYearReport() {
        return halfYearReport;
    }

    public void setHalfYearReport(String halfYearReport) {
        this.halfYearReport = halfYearReport;
    }

    public String getYearReport() {
        return yearReport;
    }

    public void setYearReport(String yearReport) {
        this.yearReport = yearReport;
    }

    public String getSeasonReport() {
        return seasonReport;
    }

    public void setSeasonReport(String seasonReport) {
        this.seasonReport = seasonReport;
    }
}
