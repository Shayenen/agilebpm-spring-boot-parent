package com.dstz.device.core.model;

import com.dstz.base.core.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class DeviceBasic extends BaseModel {

    private String deviceBasicId;

    private String deviceBasicName;

    private String deviceBasicBodynumber;

    private String deviceBasicVerson;

    private String deviceBasicCategory;

    private String deviceBasicType;

    private String deviceBasicParentEquipment;

    private String deviceBasicSite;

    private String deviceBasicStatus;

    private String deviceBasicFactorydate;

    private String deviceBasicFactoryNumber;

    private String deviceBasicPurchaseAmount;

    private String deviceBasicSavePlace;

    private String deviceBasicUserDepartment;

    private String deviceBasicLeader;

    private String deviceBasicSetupTime;

    private String deviceBasicBrand;

    private String deviceBasicProvider;

    private String deviceBasicPurchaseTime;

    private byte[] deviceBasicImg;

    private MultipartFile file;

    private String deviceBasicMesh;
    private String deviceBasicEnclosure;
    private String deviceBasicIp;
    private String deviceBasicColumnNumber;


    public String getDeviceBasicMesh() {
        return deviceBasicMesh;
    }

    public void setDeviceBasicMesh(String deviceBasicMesh) {
        this.deviceBasicMesh = deviceBasicMesh;
    }

    public String getDeviceBasicEnclosure() {
        return deviceBasicEnclosure;
    }

    public void setDeviceBasicEnclosure(String deviceBasicEnclosure) {
        this.deviceBasicEnclosure = deviceBasicEnclosure;
    }

    public String getDeviceBasicIp() {
        return deviceBasicIp;
    }

    public void setDeviceBasicIp(String deviceBasicIp) {
        this.deviceBasicIp = deviceBasicIp;
    }

    public String getDeviceBasicColumnNumber() {
        return deviceBasicColumnNumber;
    }

    public void setDeviceBasicColumnNumber(String deviceBasicColumnNumber) {
        this.deviceBasicColumnNumber = deviceBasicColumnNumber;
    }

    public String getDeviceBasicId() {
        return deviceBasicId;
    }

    public void setDeviceBasicId(String deviceBasicId) {
        this.deviceBasicId = deviceBasicId == null ? null : deviceBasicId.trim();
    }

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
        this.deviceBasicCategory = deviceBasicCategory;
    }

    public String getDeviceBasicType() {
        return deviceBasicType;
    }

    public void setDeviceBasicType(String deviceBasicType) {
        this.deviceBasicType = deviceBasicType;
    }

    public String getDeviceBasicParentEquipment() {
        return deviceBasicParentEquipment;
    }

    public void setDeviceBasicParentEquipment(String deviceBasicParentEquipment) {
        this.deviceBasicParentEquipment = deviceBasicParentEquipment == null ? null : deviceBasicParentEquipment.trim();
    }

    public String getDeviceBasicSite() {
        return deviceBasicSite;
    }

    public void setDeviceBasicSite(String deviceBasicSite) {
        this.deviceBasicSite = deviceBasicSite == null ? null : deviceBasicSite.trim();
    }

    public String getDeviceBasicStatus() {
        return deviceBasicStatus;
    }

    public void setDeviceBasicStatus(String deviceBasicStatus) {
        this.deviceBasicStatus = deviceBasicStatus;
    }

    public String getDeviceBasicFactorydate() {
        return deviceBasicFactorydate;
    }

    public void setDeviceBasicFactorydate(String deviceBasicFactorydate) {
        this.deviceBasicFactorydate = deviceBasicFactorydate;
    }

    public String getDeviceBasicFactoryNumber() {
        return deviceBasicFactoryNumber;
    }

    public void setDeviceBasicFactoryNumber(String deviceBasicFactoryNumber) {
        this.deviceBasicFactoryNumber = deviceBasicFactoryNumber == null ? null : deviceBasicFactoryNumber.trim();
    }

    public String getDeviceBasicPurchaseAmount() {
        return deviceBasicPurchaseAmount;
    }

    public void setDeviceBasicPurchaseAmount(String deviceBasicPurchaseAmount) {
        this.deviceBasicPurchaseAmount = deviceBasicPurchaseAmount == null ? null : deviceBasicPurchaseAmount.trim();
    }

    public String getDeviceBasicSavePlace() {
        return deviceBasicSavePlace;
    }

    public void setDeviceBasicSavePlace(String deviceBasicSavePlace) {
        this.deviceBasicSavePlace = deviceBasicSavePlace == null ? null : deviceBasicSavePlace.trim();
    }

    public String getDeviceBasicUserDepartment() {
        return deviceBasicUserDepartment;
    }

    public void setDeviceBasicUserDepartment(String deviceBasicUserDepartment) {
        this.deviceBasicUserDepartment = deviceBasicUserDepartment == null ? null : deviceBasicUserDepartment.trim();
    }

    public String getDeviceBasicLeader() {
        return deviceBasicLeader;
    }

    public void setDeviceBasicLeader(String deviceBasicLeader) {
        this.deviceBasicLeader = deviceBasicLeader == null ? null : deviceBasicLeader.trim();
    }

    public String getDeviceBasicSetupTime() {
        return deviceBasicSetupTime;
    }

    public void setDeviceBasicSetupTime(String deviceBasicSetupTime) {
        this.deviceBasicSetupTime = deviceBasicSetupTime;
    }

    public String getDeviceBasicBrand() {
        return deviceBasicBrand;
    }

    public void setDeviceBasicBrand(String deviceBasicBrand) {
        this.deviceBasicBrand = deviceBasicBrand == null ? null : deviceBasicBrand.trim();
    }

    public String getDeviceBasicProvider() {
        return deviceBasicProvider;
    }

    public void setDeviceBasicProvider(String deviceBasicProvider) {
        this.deviceBasicProvider = deviceBasicProvider == null ? null : deviceBasicProvider.trim();
    }

    public String getDeviceBasicPurchaseTime() {
        return deviceBasicPurchaseTime;
    }

    public void setDeviceBasicPurchaseTime(String deviceBasicPurchaseTime) {
        this.deviceBasicPurchaseTime = deviceBasicPurchaseTime == null ? null : deviceBasicPurchaseTime.trim();
    }

    public byte[] getDeviceBasicImg() {
        return deviceBasicImg;
    }

    public void setDeviceBasicImg(byte[] deviceBasicImg) {
        this.deviceBasicImg = deviceBasicImg;
    }

    public void setFile(MultipartFile file){
        this.file=file;
    }
    public MultipartFile getFile(){
        return file;
    }
}