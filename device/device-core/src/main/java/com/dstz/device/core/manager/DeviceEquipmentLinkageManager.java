package com.dstz.device.core.manager;

import com.dstz.base.manager.Manager;
import com.dstz.device.core.model.DeviceEquipmentLinkage;
import com.dstz.device.core.model.DeviceWarning;
import org.springframework.web.multipart.MultipartFile;

public interface DeviceEquipmentLinkageManager extends Manager<String, DeviceEquipmentLinkage> {

    /**
     * 导入关系数据
     * @param file
     */
    public void importExcel(MultipartFile file) throws Exception;



}
