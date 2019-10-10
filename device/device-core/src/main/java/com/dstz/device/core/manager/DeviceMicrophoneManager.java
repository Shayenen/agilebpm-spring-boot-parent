package com.dstz.device.core.manager;

import com.dstz.base.manager.Manager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceLight;
import com.dstz.device.core.model.DeviceMicrophone;
import org.springframework.web.multipart.MultipartFile;

public interface DeviceMicrophoneManager extends Manager<String, DeviceMicrophone> {

    /**
     * 音频设备保存
     * @param file
     * @param deviceBasic
     * @param deviceMicrophone
     */
    void createMicrophone(MultipartFile file, DeviceBasic deviceBasic, DeviceMicrophone deviceMicrophone) throws Exception;

    /**
     * 修改音频设备
     * @param file
     * @param deviceBasic
     * @param deviceMicrophone
     * @throws Exception
     */
    void updateMicrophone(MultipartFile file, DeviceBasic deviceBasic, DeviceMicrophone deviceMicrophone) throws Exception;

    /**
     * 音频详情
     * @param id
     * @return
     */
    DeviceMicrophone getDeviceMicrophone(String id);


}
