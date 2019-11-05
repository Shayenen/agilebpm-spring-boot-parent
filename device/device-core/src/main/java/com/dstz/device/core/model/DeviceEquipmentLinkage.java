package com.dstz.device.core.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.dstz.base.core.model.BaseModel;

public class DeviceEquipmentLinkage extends BaseModel {

    private String deviceEquipmentLinkageId;
    @Excel(name="传感器ID",orderNum="1",width = 18)
    private String deviceSensorId;
    @Excel(name="视频ID",orderNum="2",width = 18)
    private String deviceCameraId;
    @Excel(name="灯光ID",orderNum="3",width = 18)
    private String deviceLightId;
    @Excel(name="号角ID",orderNum="4",width = 18)
    private String deviceMicrophoneId;

    public String getDeviceEquipmentLinkageId() {
        return deviceEquipmentLinkageId;
    }

    public void setDeviceEquipmentLinkageId(String deviceEquipmentLinkageId) {
        this.deviceEquipmentLinkageId = deviceEquipmentLinkageId;
    }

    public String getDeviceSensorId() {
        return deviceSensorId;
    }

    public void setDeviceSensorId(String deviceSensorId) {
        this.deviceSensorId = deviceSensorId;
    }

    public String getDeviceCameraId() {
        return deviceCameraId;
    }

    public void setDeviceCameraId(String deviceCameraId) {
        this.deviceCameraId = deviceCameraId;
    }

    public String getDeviceLightId() {
        return deviceLightId;
    }

    public void setDeviceLightId(String deviceLightId) {
        this.deviceLightId = deviceLightId;
    }

    public String getDeviceMicrophoneId() {
        return deviceMicrophoneId;
    }

    public void setDeviceMicrophoneId(String deviceMicrophoneId) {
        this.deviceMicrophoneId = deviceMicrophoneId;
    }
}
