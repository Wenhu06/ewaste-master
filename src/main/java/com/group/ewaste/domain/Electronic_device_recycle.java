package com.group.ewaste.domain;

import java.util.Date;

public class Electronic_device_recycle {
    private Long id;

    private Long productid;

    private Integer userid;

    private Double price;

    private Integer deviceType;

    private Integer quality;

    private Integer hidden;

    private Double estimateValue;

    private Date uploadTime;

    private String picUrl;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Double getEstimateValue() {
        return estimateValue;
    }

    public void setEstimateValue(Double estimateValue) {
        this.estimateValue = estimateValue;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productid=").append(productid);
        sb.append(", userid=").append(userid);
        sb.append(", price=").append(price);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", quality=").append(quality);
        sb.append(", hidden=").append(hidden);
        sb.append(", estimateValue=").append(estimateValue);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}