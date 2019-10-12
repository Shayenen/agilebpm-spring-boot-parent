package com.dstz.device.core.manager;

import com.dstz.base.manager.Manager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceLight;
import com.dstz.device.core.model.DeviceMicrophone;
import org.springframework.web.multipart.MultipartFile;

public interface DeviceMicrophoneManager extends Manager<String, DeviceMicrophone> {


    /**
     * 音频详情
     * @param id
     * @return
     */
    DeviceMicrophone getDeviceMicrophone(String id);


}
