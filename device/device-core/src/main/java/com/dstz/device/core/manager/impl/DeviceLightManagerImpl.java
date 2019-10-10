package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.DeviceBasicDao;
import com.dstz.device.core.dao.DeviceCameraDao;
import com.dstz.device.core.dao.DeviceLightDao;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.manager.DeviceLightManager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;
import com.dstz.device.core.model.DeviceLight;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;

import static com.dstz.device.core.utils.FileUtils.getFileByte;

@Service("deviceLightManager")
public class DeviceLightManagerImpl extends BaseManager<String, DeviceLight> implements DeviceLightManager {
    @Resource
    DeviceBasicDao deviceBasicDao;
    @Resource
    DeviceLightDao deviceLightDao;

    /**
     * 灯光设备保存
     *
     * @param file
     * @param deviceBasic
     * @param deviceLight
     */
    @Override
    public void createLight(MultipartFile file, DeviceBasic deviceBasic, DeviceLight deviceLight) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasic.setDeviceBasicId(IdUtil.getSuid());
        deviceLight.setDeviceBasicId(deviceBasic.getDeviceBasicId());
        deviceLight.setDeviceLightId(IdUtil.getSuid());
        deviceBasicDao.create(deviceBasic);
        System.out.println(JSONObject.toJSONString(deviceBasic));
        System.out.println(JSONObject.toJSONString(deviceLight));
        deviceLightDao.create(deviceLight);
    }

    /**
     * 修改灯光设备
     *
     * @param file
     * @param deviceBasic
     * @param deviceLight
     * @throws Exception
     */
    @Override
    public void updateLight(MultipartFile file, DeviceBasic deviceBasic, DeviceLight deviceLight) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasicDao.update(deviceBasic);
        deviceLightDao.update(deviceLight);
    }

    /**
     * 灯光详情
     *
     * @param id
     * @return
     */
    @Override
    public DeviceLight getDeviceLight(String id) {
        return deviceLightDao.getByDeviceBaiscId(id);
    }


}
