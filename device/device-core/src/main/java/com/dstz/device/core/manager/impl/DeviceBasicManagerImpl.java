package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.*;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;
import com.dstz.device.core.model.DeviceLight;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;

import static com.dstz.device.core.utils.FileUtils.getFileByte;

@Service("deviceBasicManager")
public class DeviceBasicManagerImpl  extends BaseManager<String, DeviceBasic> implements DeviceBasicManager {
    @Resource
    DeviceBasicDao deviceBasicDao;
    @Resource
    DeviceCameraDao deviceCameraDao;
    @Resource
    DeviceLightDao deviceLightDao;
    @Resource
    DeviceMicrophoneDao deviceMicrophoneDao;
    @Resource
    DeviceSensorDao deviceSensorDao;

    /**
     * 视频设备保存
     *
     * @param file
     * @param deviceBasic
     * @param deviceCamera
     */
    @Override
    public void createCamera(MultipartFile file, DeviceBasic deviceBasic, DeviceCamera deviceCamera) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasic.setDeviceBasicId(IdUtil.getSuid());
        deviceCamera.setDeviceBasicId(deviceBasic.getDeviceBasicId());
        deviceCamera.setDeviceCameraId(IdUtil.getSuid());
        deviceBasicDao.create(deviceBasic);
        System.out.println(JSONObject.toJSONString(deviceBasic));
        System.out.println(JSONObject.toJSONString(deviceCamera));
        deviceCameraDao.create(deviceCamera);
    }

    /**
     * 修改视频设备
     *
     * @param file
     * @param deviceBasic
     * @param deviceCamera
     * @throws Exception
     */
    @Override
    public void updateCamera(MultipartFile file, DeviceBasic deviceBasic, DeviceCamera deviceCamera) throws Exception {
        if (file!=null && !file.isEmpty()){
            deviceBasic.setDeviceBasicImg(getFileByte(file));
        }
        deviceBasicDao.update(deviceBasic);
        deviceCameraDao.update(deviceCamera);
    }

    /**
     * 摄像机详情
     *
     * @param id
     * @return
     */
    @Override
    public DeviceCamera getDeviceCamera(String id) {
        return deviceCameraDao.getByDeviceBaiscId(id);
    }

    /**
     * 删除
     *
     * @param basicId
     */
    @Override
    public void removeDevice(String basicId) {
        DeviceBasic deviceBasic = deviceBasicDao.get(basicId);
        if(deviceBasic!=null) {
            deviceBasicDao.remove(basicId);
            if (deviceBasic.getDeviceBasicCategory().equals("spjksb")) {
                //视频
                deviceCameraDao.removeByBasicId(basicId);
            }else if (deviceBasic.getDeviceBasicCategory().equals("ypsb")){
                //音频设备
                deviceMicrophoneDao.removeByBasicId(basicId);

            }else if (deviceBasic.getDeviceBasicCategory().equals("cgqsb")){
                //传感器设备
                deviceSensorDao.removeByBasicId(basicId);

            }else if (deviceBasic.getDeviceBasicCategory().equals("dgsb")){
                //灯光设备
                deviceLightDao.removeByBasicId(basicId);
            }

        }
    }
}
