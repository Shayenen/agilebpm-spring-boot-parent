package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
import java.util.Map;
import java.util.Random;

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

    @Override
    public Map getMap(String id) {
        return deviceBasicDao.getMap(id);
    }

    @Override
    public JSON getTestData() {

        String json = "[[\"product\", \"视频监控\", \"音频\", \"传感器\"]," // 产品项
                + "[\"2015\"," + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "], [\"2016\", " + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "],"
                + "[\"2017\", " + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "], [\"2019\"," + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "]]";
        JSONArray jsonArray = JSONArray.parseArray(json);

        return jsonArray;
    }

    @Override
    public JSON getTestData2() {

        String json = "[[\"product\", \"视频监控\", \"音频\", \"传感器\"]," // 产品项
                //+ "[\"2014\"," + 100 + "],"
                + "[\"2015\"," + 100 + "], [\"2016\", " + 200+ "],"
                + "[\"2017\", " + 260 + "], [\"2019\"," + 340 + "]]";
        JSONArray jsonArray = JSONArray.parseArray(json);

        return jsonArray;
    }
    private int getRandomInt() {
        Random rand = new Random();
        return rand.nextInt(6000);
    }

}
