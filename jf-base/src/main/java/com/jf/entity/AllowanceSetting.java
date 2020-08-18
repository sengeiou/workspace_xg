package com.jf.entity;

import java.util.Date;

public class AllowanceSetting {
    private Integer id;

    private String name;

    private String popupCount;

    private Integer day;

    private Date exchangeBeginDate;

    private Date exchangeEndDate;

    private String pic;

    private String status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPopupCount() {
        return popupCount;
    }

    public void setPopupCount(String popupCount) {
        this.popupCount = popupCount == null ? null : popupCount.trim();
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Date getExchangeBeginDate() {
        return exchangeBeginDate;
    }

    public void setExchangeBeginDate(Date exchangeBeginDate) {
        this.exchangeBeginDate = exchangeBeginDate;
    }

    public Date getExchangeEndDate() {
        return exchangeEndDate;
    }

    public void setExchangeEndDate(Date exchangeEndDate) {
        this.exchangeEndDate = exchangeEndDate;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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