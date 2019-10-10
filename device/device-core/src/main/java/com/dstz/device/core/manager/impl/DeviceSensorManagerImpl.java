package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.DeviceBasicDao;
import com.dstz.device.core.dao.DeviceLightDao;
import com.dstz.device.core.dao.DeviceSensorDao;
import com.dstz.device.core.manager.DeviceLightManager;
import com.dstz.device.core.manager.DeviceSensorManager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceLight;
import com.dstz.device.core.model.DeviceSensor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import static com.dstz.device.core.utils.FileUtils.getFileByte;

@Service("deviceSensorManager")
public class DeviceSensorManagerImpl extends BaseManager<String, DeviceSensor> implements DeviceSensorManager {
    @Resource
    DeviceBasicDao deviceBasicDao;
    @Resource
    DeviceSensorDao deviceSensorDao;

    /**
     * 传感器设备保存
     *
     * @param file
     * @param deviceBasic
     * @param deviceSensor
     */
    @Override
    public void createSensor(MultipartFile file, DeviceBasic deviceBasic, DeviceSensor deviceSensor) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasic.setDeviceBasicId(IdUtil.getSuid());
        deviceSensor.setDeviceBasicId(deviceBasic.getDeviceBasicId());
        deviceSensor.setDeviceSensorId(IdUtil.getSuid());
        deviceBasicDao.create(deviceBasic);
        System.out.println(JSONObject.toJSONString(deviceBasic));
        System.out.println(JSONObject.toJSONString(deviceSensor));
        deviceSensorDao.create(deviceSensor);
    }

    /**
     * 修改传感器设备
     *
     * @param file
     * @param deviceBasic
     * @param deviceSensor
     * @throws Exception
     */
    @Override
    public void updateSensor(MultipartFile file, DeviceBasic deviceBasic, DeviceSensor deviceSensor) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasicDao.update(deviceBasic);
        deviceSensorDao.update(deviceSensor);
    }

    /**
     * 传感器详情
     *
     * @param id
     * @return
     */
    @Override
    public DeviceSensor getDeviceSensor(String id) {
        return deviceSensorDao.getByDeviceBaiscId(id);
    }


}
