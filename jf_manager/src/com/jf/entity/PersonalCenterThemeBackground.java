package com.jf.entity;

import java.util.Date;

public class PersonalCenterThemeBackground {
    private Integer id;

    private Date beginDate;

    private Date endDate;

    private String commonThemeBackgroundPic;

    private String svipThemeBackgroundPic;

    private String status;

    private Date statusDate;

    private Integer createBy;

    private Date createDate;

    private Integer updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCommonThemeBackgroundPic() {
        return commonThemeBackgroundPic;
    }

    public void setCommonThemeBackgroundPic(String commonThemeBackgroundPic) {
        this.commonThemeBackgroundPic = commonThemeBackgroundPic == null ? null : commonThemeBackgroundPic.trim();
    }

    public String getSvipThemeBackgroundPic() {
        return svipThemeBackgroundPic;
    }

    public void setSvipThemeBackgroundPic(String svipThemeBackgroundPic) {
        this.svipThemeBackgroundPic = svipThemeBackgroundPic == null ? null : svipThemeBackgroundPic.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}