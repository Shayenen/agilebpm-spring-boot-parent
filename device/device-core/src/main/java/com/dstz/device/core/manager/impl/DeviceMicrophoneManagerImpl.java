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
    DeviceBasicDao deviceBasicDao;
    @Resource
    DeviceMicrophoneDao deviceMicrophoneDao;

    /**
     * 音频设备保存
     *
     * @param file
     * @param deviceBasic
     * @param deviceMicrophone
     */
    @Override
    public void createMicrophone(MultipartFile file, DeviceBasic deviceBasic, DeviceMicrophone deviceMicrophone) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasic.setDeviceBasicId(IdUtil.getSuid());
        deviceMicrophone.setDeviceBasicId(deviceBasic.getDeviceBasicId());
        deviceMicrophone.setDeviceMicrophoneId(IdUtil.getSuid());
        deviceBasicDao.create(deviceBasic);
        System.out.println(JSONObject.toJSONString(deviceBasic));
        System.out.println(JSONObject.toJSONString(deviceMicrophone));
        deviceMicrophoneDao.create(deviceMicrophone);
    }

    /**
     * 修改传感器设备
     *
     * @param file
     * @param deviceBasic
     * @param deviceMicrophone
     * @throws Exception
     */
    @Override
    public void updateMicrophone(MultipartFile file, DeviceBasic deviceBasic, DeviceMicrophone deviceMicrophone) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasicDao.update(deviceBasic);
        deviceMicrophoneDao.update(deviceMicrophone);
    }

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
