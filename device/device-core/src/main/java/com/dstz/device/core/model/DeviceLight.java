package com.dstz.device.core.model;

import java.io.Serializable;

public class DeviceLight implements Serializable {

    private String deviceLightId;

    private String deviceBasicId;

    private String deviceLightPower;

    private String deviceLightLuminance;

    private String deviceLightVoltage;

    private String deviceLightRemark;

    public String getDeviceLightId() {
        return deviceLightId;
    }

    public void setDeviceLightId(String deviceLightId) {
        this.deviceLightId = deviceLightId == null ? null : deviceLightId.trim();
    }

    public String getDeviceBasicId() {
        return deviceBasicId;
    }

    public void setDeviceBasicId(String deviceBasicId) {
        this.deviceBasicId = deviceBasicId == null ? null : deviceBasicId.trim();
    }

    public String getDeviceLightPower() {
        return deviceLightPower;
    }

    public void setDeviceLightPower(String deviceLightPower) {
        this.deviceLightPower = deviceLightPower == null ? null : deviceLightPower.trim();
    }

    public String getDeviceLightLuminance() {
        return deviceLightLuminance;
    }

    public void setDeviceLightLuminance(String deviceLightLuminance) {
        this.deviceLightLuminance = deviceLightLuminance == null ? null : deviceLightLuminance.trim();
    }

    public String getDeviceLightVoltage() {
        return deviceLightVoltage;
    }

    public void setDeviceLightVoltage(String deviceLightVoltage) {
        this.deviceLightVoltage = deviceLightVoltage == null ? null : deviceLightVoltage.trim();
    }

    public String getDeviceLightRemark() {
        return deviceLightRemark;
    }

    public void setDeviceLightRemark(String deviceLightRemark) {
        this.deviceLightRemark = deviceLightRemark == null ? null : deviceLightRemark.trim();
    }
}