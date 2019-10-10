package com.dstz.device.core.manager;

import com.dstz.base.manager.Manager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceMicrophone;
import com.dstz.device.core.model.DeviceSensor;
import org.springframework.web.multipart.MultipartFile;

public interface DeviceSensorManager extends Manager<String, DeviceSensor> {

    /**
     * 传感器设备保存
     * @param file
     * @param deviceBasic
     * @param deviceSensor
     */
    void createSensor(MultipartFile file, DeviceBasic deviceBasic, DeviceSensor deviceSensor) throws Exception;

    /**
     * 修改传感器设备
     * @param file
     * @param deviceBasic
     * @param deviceSensor
     * @throws Exception
     */
    void updateSensor(MultipartFile file, DeviceBasic deviceBasic, DeviceSensor deviceSensor) throws Exception;

    /**
     * 传感器详情
     * @param id
     * @return
     */
    DeviceSensor getDeviceSensor(String id);


}
