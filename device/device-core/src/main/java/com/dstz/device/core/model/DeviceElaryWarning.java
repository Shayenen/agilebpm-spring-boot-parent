package com.dstz.device.core.model;

import java.io.Serializable;
import java.util.Date;

public class DeviceElaryWarning implements Serializable {
    private String deviceElaryWarningId;

    private String deviceElaryWarningNumber;

    private Date deviceElaryWarningTime;

    private String deviceElaryWarningDefenceArea;

    private String deviceElaryWarningNode;

    private String deviceElaryWarningColumnNumber;

    private String deviceElaryWarningType;

    private String deviceElaryWarningDecide;

    private String deviceElaryWarningHandle;

    private Date deviceElaryWarningHandelTime;

    private String deviceElaryWarningStatus;

    public String getDeviceElaryWarningStatus() {
        return deviceElaryWarningStatus;
    }

    public void setDeviceElaryWarningStatus(String deviceElaryWarningStatus) {
        this.deviceElaryWarningStatus = deviceElaryWarningStatus;
    }

    public String getDeviceElaryWarningId() {
        return deviceElaryWarningId;
    }

    public void setDeviceElaryWarningId(String deviceElaryWarningId) {
        this.deviceElaryWarningId = deviceElaryWarningId == null ? null : deviceElaryWarningId.trim();
    }

    public String getDeviceElaryWarningNumber() {
        return deviceElaryWarningNumber;
    }

    public void setDeviceElaryWarningNumber(String deviceElaryWarningNumber) {
        this.deviceElaryWarningNumber = deviceElaryWarningNumber == null ? null : deviceElaryWarningNumber.trim();
    }

    public Date getDeviceElaryWarningTime() {
        return deviceElaryWarningTime;
    }

    public void setDeviceElaryWarningTime(Date deviceElaryWarningTime) {
        this.deviceElaryWarningTime = deviceElaryWarningTime;
    }

    public String getDeviceElaryWarningDefenceArea() {
        return deviceElaryWarningDefenceArea;
    }

    public void setDeviceElaryWarningDefenceArea(String deviceElaryWarningDefenceArea) {
        this.deviceElaryWarningDefenceArea = deviceElaryWarningDefenceArea == null ? null : deviceElaryWarningDefenceArea.trim();
    }

    public String getDeviceElaryWarningNode() {
        return deviceElaryWarningNode;
    }

    public void setDeviceElaryWarningNode(String deviceElaryWarningNode) {
        this.deviceElaryWarningNode = deviceElaryWarningNode == null ? null : deviceElaryWarningNode.trim();
    }

    public String getDeviceElaryWarningColumnNumber() {
        return deviceElaryWarningColumnNumber;
    }

    public void setDeviceElaryWarningColumnNumber(String deviceElaryWarningColumnNumber) {
        this.deviceElaryWarningColumnNumber = deviceElaryWarningColumnNumber == null ? null : deviceElaryWarningColumnNumber.trim();
    }

    public String getDeviceElaryWarningType() {
        return deviceElaryWarningType;
    }

    public void setDeviceElaryWarningType(String deviceElaryWarningType) {
        this.deviceElaryWarningType = deviceElaryWarningType == null ? null : deviceElaryWarningType.trim();
    }

    public String getDeviceElaryWarningDecide() {
        return deviceElaryWarningDecide;
    }

    public void setDeviceElaryWarningDecide(String deviceElaryWarningDecide) {
        this.deviceElaryWarningDecide = deviceElaryWarningDecide == null ? null : deviceElaryWarningDecide.trim();
    }

    public String getDeviceElaryWarningHandle() {
        return deviceElaryWarningHandle;
    }

    public void setDeviceElaryWarningHandle(String deviceElaryWarningHandle) {
        this.deviceElaryWarningHandle = deviceElaryWarningHandle == null ? null : deviceElaryWarningHandle.trim();
    }

    public Date getDeviceElaryWarningHandelTime() {
        return deviceElaryWarningHandelTime;
    }

    public void setDeviceElaryWarningHandelTime(Date deviceElaryWarningHandelTime) {
        this.deviceElaryWarningHandelTime = deviceElaryWarningHandelTime;
    }
}