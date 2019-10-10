package com.dstz.device.core.manager;

import com.dstz.base.manager.Manager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;
import com.dstz.device.core.model.DeviceLight;
import org.springframework.web.multipart.MultipartFile;

public interface DeviceLightManager extends Manager<String, DeviceLight> {

    /**
     * 灯光设备保存
     * @param file
     * @param deviceBasic
     * @param deviceLight
     */
    void createLight(MultipartFile file, DeviceBasic deviceBasic, DeviceLight deviceLight) throws Exception;

    /**
     * 修改视频设备
     * @param file
     * @param deviceBasic
     * @param deviceLight
     * @throws Exception
     */
    void updateLight(MultipartFile file, DeviceBasic deviceBasic,DeviceLight deviceLight) throws Exception;

    /**
     * 灯光详情
     * @param id
     * @return
     */
    DeviceLight getDeviceLight(String id);


}
