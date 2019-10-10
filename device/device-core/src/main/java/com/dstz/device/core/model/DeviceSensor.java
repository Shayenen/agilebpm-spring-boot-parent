package com.dstz.device.core.model;

import java.io.Serializable;

public class DeviceSensor implements Serializable {
    private String deviceSensorId;

    private String deviceBasicId;

    private String deviceSensorRemark;

    public String getDeviceSensorId() {
        return deviceSensorId;
    }

    public void setDeviceSensorId(String deviceSensorId) {
        this.deviceSensorId = deviceSensorId == null ? null : deviceSensorId.trim();
    }

    public String getDeviceBasicId() {
        return deviceBasicId;
    }

    public void setDeviceBasicId(String deviceBasicId) {
        this.deviceBasicId = deviceBasicId == null ? null : deviceBasicId.trim();
    }

    public String getDeviceSensorRemark() {
        return deviceSensorRemark;
    }

    public void setDeviceSensorRemark(String deviceSensorRemark) {
        this.deviceSensorRemark = deviceSensorRemark == null ? null : deviceSensorRemark.trim();
    }
}