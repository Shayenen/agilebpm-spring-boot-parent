package com.dstz.device.rest.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.dstz.base.manager.Manager;
import com.dstz.base.rest.BaseController;
import com.dstz.device.core.manager.DeviceEquipmentLinkageManager;
import com.dstz.device.core.model.DeviceElaryWarning;
import com.dstz.device.core.model.DeviceEquipmentLinkage;
import com.dstz.device.core.model.DeviceWarning;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/equipmentLinkage/api/")
@Api(description = "设备联动关系管理")
public class DeviceEquipmentLinkageController  extends BaseController<DeviceEquipmentLinkage> {

    @Autowired
    DeviceEquipmentLinkageManager deviceEquipmentLinkageManager;

    @Override
    protected String getModelDesc() {
        return "设备联动关系管理";
    }
    /**
     * 导入Excel
     */
    @RequestMapping("/importExcel")
    public String importExcel(@RequestParam() MultipartFile file) {

        try {
            deviceEquipmentLinkageManager.importExcel(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
