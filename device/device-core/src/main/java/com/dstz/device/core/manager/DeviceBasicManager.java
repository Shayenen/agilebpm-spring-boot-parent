package com.dstz.device.core.manager;

import com.alibaba.fastjson.JSON;
import com.dstz.base.manager.Manager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface DeviceBasicManager extends Manager<String, DeviceBasic> {


    /**
     * 新增或修改设备信息
     * @param json
     * @return
     * @throws Exception
     */
    String createOrUpdateDevice(String json);

    /**
     * 摄像机详情
     * @param id
     * @return
     */
    DeviceCamera getDeviceCamera(String id);

    /**
     * 删除
     * @param basicId
     */
    void removeDevice(String basicId);

    Map getMap(String id);

    JSON getTestData();
    JSON getTestData2();
}
