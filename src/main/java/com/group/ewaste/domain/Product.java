package com.group.ewaste.domain;

import java.util.Date;

public class Product {
    private Long id;

    private Integer categoryid;

    private Integer name;

    private Date releaseTime;

    private Double price;

    private String picUrl;

    private String remark;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        sb.append(", categoryid=").append(categoryid);
        sb.append(", name=").append(name);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", price=").append(price);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}