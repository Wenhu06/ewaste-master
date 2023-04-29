package com.group.ewaste.domain;

public class Electronic_device_recycle_order {
    private Long id;

    private Long deviceRecycleId;

    private Integer type;

    private Integer status;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}