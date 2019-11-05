package com.dstz.device.core.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.dstz.base.api.model.IDModel;
import com.dstz.base.core.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

@ExcelTarget("deviceElaryWarning")
public class DeviceElaryWarning extends BaseModel {

    private String deviceElaryWarningId;
    @Excel(name="报警编号",orderNum="1",width = 18)
    private String deviceElaryWarningNumber;
    @Excel(name="报警时间",orderNum="2",exportFormat="yyyy-MM-dd hh:mm:ss",width = 18)
    private Date deviceElaryWarningTime;
    @Excel(name="报警防区",orderNum="3",width = 18)
    private String deviceElaryWarningDefenceArea;
    @Excel(name="相关节点",orderNum="4",width = 18)
    private String deviceElaryWarningNode;
    @Excel(name="立柱号",orderNum="5",width = 18)
    private String deviceElaryWarningColumnNumber;
    @Excel(name="报警类型",orderNum="6",width = 18)
    private String deviceElaryWarningType;
    @Excel(name="报警判断",orderNum="7",width = 18)
    private String deviceElaryWarningDecide;
    @Excel(name="处理人",orderNum="8",width = 18)
    private String deviceElaryWarningHandle;
    @Excel(name="处理时间",orderNum="9",exportFormat="yyyy-MM-dd hh:mm:ss",width = 18)
    private Date deviceElaryWarningHandelTime;
    //@Excel(name="添加时间",orderNum="1",exportFormat="yyyy-MM-dd hh:mm:ss",width = 18)
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