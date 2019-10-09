package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.DeviceBasicDao;
import com.dstz.device.core.dao.DeviceCameraDao;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;

@Service("deviceBasicManager")
public class DeviceBasicManagerImpl  extends BaseManager<String, DeviceBasic> implements DeviceBasicManager {
    @Resource
    DeviceBasicDao deviceBasicDao;
    @Resource
    DeviceCameraDao deviceCameraDao;

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
            InputStream inputStream = file.getInputStream();
            byte[] pictureData = new byte[(int) file.getSize()];
            inputStream.read(pictureData);
            deviceBasic.setDeviceBasicImg(pictureData);
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
            InputStream inputStream = file.getInputStream();
            byte[] pictureData = new byte[(int) file.getSize()];
            inputStream.read(pictureData);
            deviceBasic.setDeviceBasicImg(pictureData);
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
     * 摄像机删除
     *
     * @param basicId
     */
    @Override
    public void removeCamera(String basicId) {
        deviceBasicDao.remove(basicId);
        deviceCameraDao.removeByBasicId(basicId);
    }
}
