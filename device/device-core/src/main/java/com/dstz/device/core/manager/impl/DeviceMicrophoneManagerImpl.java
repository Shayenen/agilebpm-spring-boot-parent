package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.DeviceBasicDao;
import com.dstz.device.core.dao.DeviceMicrophoneDao;
import com.dstz.device.core.dao.DeviceSensorDao;
import com.dstz.device.core.manager.DeviceMicrophoneManager;
import com.dstz.device.core.manager.DeviceSensorManager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceMicrophone;
import com.dstz.device.core.model.DeviceSensor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import static com.dstz.device.core.utils.FileUtils.getFileByte;

@Service("deviceMicrophoneManager")
public class DeviceMicrophoneManagerImpl extends BaseManager<String, DeviceMicrophone> implements DeviceMicrophoneManager {

    @Resource
    DeviceMicrophoneDao deviceMicrophoneDao;


    /**
     * 传感器详情
     *
     * @param id
     * @return
     */
    @Override
    public DeviceMicrophone getDeviceMicrophone(String id) {
        return deviceMicrophoneDao.getByDeviceBaiscId(id);
    }


}
