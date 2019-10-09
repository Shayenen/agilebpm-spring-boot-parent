package com.dstz.device.core.dto;

import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;

public class DeviceBasicCameraDto extends DeviceBasic {

    private String deviceCameraId;

    private String deviceBasicId;

    private Integer deviceCameraShotNumber;

    private String deviceCameraPx;

    private String deviceCameraSize;

    private String deviceCameraStream;

    private String deviceCameraRemark;

    public String getDeviceCameraId() {
        return deviceCameraId;
    }

    public void setDeviceCameraId(String deviceCameraId) {
        this.deviceCameraId = deviceCameraId == null ? null : deviceCameraId.trim();
    }

    public String getDeviceBasicId() {
        return deviceBasicId;
    }

    public void setDeviceBasicId(String deviceBasicId) {
        this.deviceBasicId = deviceBasicId == null ? null : deviceBasicId.trim();
    }

    public Integer getDeviceCameraShotNumber() {
        return deviceCameraShotNumber;
    }

    public void setDeviceCameraShotNumber(Integer deviceCameraShotNumber) {
        this.deviceCameraShotNumber = deviceCameraShotNumber;
    }

    public String getDeviceCameraPx() {
        return deviceCameraPx;
    }

    public void setDeviceCameraPx(String deviceCameraPx) {
        this.deviceCameraPx = deviceCameraPx == null ? null : deviceCameraPx.trim();
    }

    public String getDeviceCameraSize() {
        return deviceCameraSize;
    }

    public void setDeviceCameraSize(String deviceCameraSize) {
        this.deviceCameraSize = deviceCameraSize == null ? null : deviceCameraSize.trim();
    }

    public String getDeviceCameraStream() {
        return deviceCameraStream;
    }

    public void setDeviceCameraStream(String deviceCameraStream) {
        this.deviceCameraStream = deviceCameraStream == null ? null : deviceCameraStream.trim();
    }

    public String getDeviceCameraRemark() {
        return deviceCameraRemark;
    }

    public void setDeviceCameraRemark(String deviceCameraRemark) {
        this.deviceCameraRemark = deviceCameraRemark == null ? null : deviceCameraRemark.trim();
    }
}
