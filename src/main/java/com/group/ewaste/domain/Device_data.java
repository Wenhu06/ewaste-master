package com.group.ewaste.domain;

public class Device_data {
    private Long id;

    private Long deviceRecycleId;

    private String ossUrl;

    private Integer access;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceRecycleId() {
        return deviceRecycleId;
    }

    public void setDeviceRecycleId(Long deviceRecycleId) {
        this.deviceRecycleId = deviceRecycleId;
    }

    public String getOssUrl() {
        return ossUrl;
    }

    public void setOssUrl(String ossUrl) {
        this.ossUrl = ossUrl;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
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
        sb.append(", deviceRecycleId=").append(deviceRecycleId);
        sb.append(", ossUrl=").append(ossUrl);
        sb.append(", access=").append(access);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}