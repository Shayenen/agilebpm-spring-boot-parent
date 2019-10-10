package com.dstz.device.core.model;

import java.io.Serializable;

public class DeviceMicrophone implements Serializable {
    private String deviceMicrophoneId;

    private String deviceBasicId;

    private String deviceMicrophonePower;

    private String deviceMicrophoneStream;

    private String deviceMicrophoneRemark;

    public String getDeviceMicrophoneId() {
        return deviceMicrophoneId;
    }

    public void setDeviceMicrophoneId(String deviceMicrophoneId) {
        this.deviceMicrophoneId = deviceMicrophoneId == null ? null : deviceMicrophoneId.trim();
    }

    public String getDeviceBasicId() {
        return deviceBasicId;
    }

    public void setDeviceBasicId(String deviceBasicId) {
        this.deviceBasicId = deviceBasicId == null ? null : deviceBasicId.trim();
    }

    public String getDeviceMicrophonePower() {
        return deviceMicrophonePower;
    }

    public void setDeviceMicrophonePower(String deviceMicrophonePower) {
        this.deviceMicrophonePower = deviceMicrophonePower == null ? null : deviceMicrophonePower.trim();
    }

    public String getDeviceMicrophoneStream() {
        return deviceMicrophoneStream;
    }

    public void setDeviceMicrophoneStream(String deviceMicrophoneStream) {
        this.deviceMicrophoneStream = deviceMicrophoneStream == null ? null : deviceMicrophoneStream.trim();
    }

    public String getDeviceMicrophoneRemark() {
        return deviceMicrophoneRemark;
    }

    public void setDeviceMicrophoneRemark(String deviceMicrophoneRemark) {
        this.deviceMicrophoneRemark = deviceMicrophoneRemark == null ? null : deviceMicrophoneRemark.trim();
    }
}