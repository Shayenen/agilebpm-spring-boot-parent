package com.dstz.device.core.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.dstz.base.core.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

public class DeviceWarning extends BaseModel {
    private String deviceWarningId;
    @Excel(name="报警编号",orderNum="1",width = 18)
    private String deviceWarningNumber;
    @Excel(name="报警时间",orderNum="2",exportFormat="yyyy-MM-dd hh:mm:ss",width = 18)
    private Date deviceWarningTime;
    @Excel(name="设备名称",orderNum="3",width = 18)
    private String deviceWarningDeviceName;
    @Excel(name="设备编号",orderNum="4",width = 18)
    private String deviceWarningDeviceNumber;
    @Excel(name="设备防区",orderNum="5",width = 18)
    private String deviceWarningDefenceArea;
    @Excel(name="设备型号",orderNum="6",width = 18)
    private String deviceWarningDeviceModel;
    @Excel(name="设备类型",orderNum="7",width = 18)
    private String deviceWarningDeviceType;
    @Excel(name="情况描述",orderNum="8",width = 18)
    private String deviceWarningDetail;
    @Excel(name="报警状态",orderNum="9",width = 18)
    private String deviceWarningStatus;

    private Date createTime;

    public String getDeviceWarningId() {
        return deviceWarningId;
    }

    public void setDeviceWarningId(String deviceWarningId) {
        this.deviceWarningId = deviceWarningId == null ? null : deviceWarningId.trim();
    }

    public String getDeviceWarningNumber() {
        return deviceWarningNumber;
    }

    public void setDeviceWarningNumber(String deviceWarningNumber) {
        this.deviceWarningNumber = deviceWarningNumber == null ? null : deviceWarningNumber.trim();
    }

    public Date getDeviceWarningTime() {
        return deviceWarningTime;
    }

    public void setDeviceWarningTime(Date deviceWarningTime) {
        this.deviceWarningTime = deviceWarningTime;
    }

    public String getDeviceWarningDeviceName() {
        return deviceWarningDeviceName;
    }

    public void setDeviceWarningDeviceName(String deviceWarningDeviceName) {
        this.deviceWarningDeviceName = deviceWarningDeviceName == null ? null : deviceWarningDeviceName.trim();
    }

    public String getDeviceWarningDeviceNumber() {
        return deviceWarningDeviceNumber;
    }

    public void setDeviceWarningDeviceNumber(String deviceWarningDeviceNumber) {
        this.deviceWarningDeviceNumber = deviceWarningDeviceNumber == null ? null : deviceWarningDeviceNumber.trim();
    }

    public String getDeviceWarningDefenceArea() {
        return deviceWarningDefenceArea;
    }

    public void setDeviceWarningDefenceArea(String deviceWarningDefenceArea) {
        this.deviceWarningDefenceArea = deviceWarningDefenceArea == null ? null : deviceWarningDefenceArea.trim();
    }

    public String getDeviceWarningDeviceModel() {
        return deviceWarningDeviceModel;
    }

    public void setDeviceWarningDeviceModel(String deviceWarningDeviceModel) {
        this.deviceWarningDeviceModel = deviceWarningDeviceModel == null ? null : deviceWarningDeviceModel.trim();
    }

    public String getDeviceWarningDeviceType() {
        return deviceWarningDeviceType;
    }

    public void setDeviceWarningDeviceType(String deviceWarningDeviceType) {
        this.deviceWarningDeviceType = deviceWarningDeviceType == null ? null : deviceWarningDeviceType.trim();
    }

    public String getDeviceWarningDetail() {
        return deviceWarningDetail;
    }

    public void setDeviceWarningDetail(String deviceWarningDetail) {
        this.deviceWarningDetail = deviceWarningDetail == null ? null : deviceWarningDetail.trim();
    }

    public String getDeviceWarningStatus() {
        return deviceWarningStatus;
    }

    public void setDeviceWarningStatus(String deviceWarningStatus) {
        this.deviceWarningStatus = deviceWarningStatus == null ? null : deviceWarningStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}