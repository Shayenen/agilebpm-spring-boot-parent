package com.dstz.device.core.manager.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.DeviceEquipmentLinkageDao;
import com.dstz.device.core.manager.DeviceEquipmentLinkageManager;
import com.dstz.device.core.manager.DeviceWarningManager;
import com.dstz.device.core.model.DeviceElaryWarning;
import com.dstz.device.core.model.DeviceEquipmentLinkage;
import com.dstz.device.core.model.DeviceWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service("deviceEquipmentLinkageManager")
public class DeviceEquipmentLiknageManagerImpl extends BaseManager<String, DeviceEquipmentLinkage> implements DeviceEquipmentLinkageManager {

    @Autowired
    DeviceEquipmentLinkageDao deviceEquipmentLinkageDao;

    /**
     * 导入关系数据
     *
     * @param file
     */
    @Override
    public void importExcel(MultipartFile file) throws Exception {
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);

        // 需要验证
        importParams.setNeedVerfiy(true);

            ExcelImportResult<DeviceEquipmentLinkage> result = ExcelImportUtil.importExcelMore(file.getInputStream(), DeviceEquipmentLinkage.class,
                    importParams);

            List<DeviceEquipmentLinkage> successList = result.getList();
            //循环保存设备关联关系表
            for (DeviceEquipmentLinkage equipmentLinkage : successList) {
                equipmentLinkage.setDeviceEquipmentLinkageId(IdUtil.getSuid());
                deviceEquipmentLinkageDao.create(equipmentLinkage);
            }

    }
}
