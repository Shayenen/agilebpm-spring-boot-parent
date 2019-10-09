package com.dstz.device.core.model;

import com.dstz.base.core.model.BaseModel;

import java.util.Date;

public class DeviceBasic extends BaseModel {

    private String deviceBasicName;

    private String deviceBasicBodynumber;

    private String deviceBasicVerson;

    private String deviceBasicCategory;

    private Date deviceBasicFactorydate;

    private Integer deviceBasicStatus;

    public String getDeviceBasicName() {
        return deviceBasicName;
    }

    public void setDeviceBasicName(String deviceBasicName) {
        this.deviceBasicName = deviceBasicName == null ? null : deviceBasicName.trim();
    }

    public String getDeviceBasicBodynumber() {
        return deviceBasicBodynumber;
    }

    public void setDeviceBasicBodynumber(String deviceBasicBodynumber) {
        this.deviceBasicBodynumber = deviceBasicBodynumber == null ? null : deviceBasicBodynumber.trim();
    }

    public String getDeviceBasicVerson() {
        return deviceBasicVerson;
    }

    public void setDeviceBasicVerson(String deviceBasicVerson) {
        this.deviceBasicVerson = deviceBasicVerson == null ? null : deviceBasicVerson.trim();
    }

    public String getDeviceBasicCategory() {
        return deviceBasicCategory;
    }

    public void setDeviceBasicCategory(String deviceBasicCategory) {
        this.deviceBasicCategory = deviceBasicCategory == null ? null : deviceBasicCategory.trim();
    }

    public Date getDeviceBasicFactorydate() {
        return deviceBasicFactorydate;
    }

    public void setDeviceBasicFactorydate(Date deviceBasicFactorydate) {
        this.deviceBasicFactorydate = deviceBasicFactorydate;
    }

    public Integer getDeviceBasicStatus() {
        return deviceBasicStatus;
    }

    public void setDeviceBasicStatus(Integer deviceBasicStatus) {
        this.deviceBasicStatus = deviceBasicStatus;
    }
}