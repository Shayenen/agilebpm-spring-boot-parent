package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dstz.base.api.response.impl.ResultMsg;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.core.util.StringUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.*;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.model.*;
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
     * 新增或修改设备信息
     *
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public String createOrUpdateDevice(String json) throws Exception {
        JSONObject jsonObject = JSON.parseObject(json);
        //  在转成不同的实体类
        DeviceBasic deviceBasic = jsonObject.getObject("deviceBasic", DeviceBasic.class);

        String id=deviceBasic.getDeviceBasicId();
        if(StringUtil.isEmpty(id)){
            deviceBasic.setDeviceBasicId(IdUtil.getSuid());
            //保存基本设备信息
            deviceBasicDao.create(deviceBasic);
        }else{
            //查询原来基础设备信息
            DeviceBasic basic = deviceBasicDao.get(deviceBasic.getDeviceBasicId());
            if (basic.getDeviceBasicCategory().equals("spjksb")) {
                //删除视频设备信息
                deviceCameraDao.removeByBasicId(deviceBasic.getDeviceBasicId());
            }else if (basic.getDeviceBasicCategory().equals("ypsb")){
                //删除音频设备信息
                deviceMicrophoneDao.removeByBasicId(deviceBasic.getDeviceBasicId());
            }else if (basic.getDeviceBasicCategory().equals("cgqsb")){
                //删除传感器
                deviceSensorDao.removeByBasicId(deviceBasic.getDeviceBasicId());
            }else if (basic.getDeviceBasicCategory().equals("dgsb")){
                //删除灯光
                deviceLightDao.removeByBasicId(deviceBasic.getDeviceBasicId());
            }
            //修改基本信息设备
            deviceBasicDao.update(deviceBasic);

        }
        if (deviceBasic.getDeviceBasicCategory().equals("spjksb")) {
            //保存视频设备信息
            DeviceCamera deviceCamera = jsonObject.getObject("deviceCamera", DeviceCamera.class);
            deviceCamera.setDeviceBasicId(deviceBasic.getDeviceBasicId());
            deviceCamera.setDeviceCameraId(IdUtil.getSuid());
            deviceCameraDao.create(deviceCamera);

        }else if (deviceBasic.getDeviceBasicCategory().equals("ypsb")){
            //保存音频设备信息
            DeviceMicrophone deviceMicrophone = jsonObject.getObject("deviceMicrophone", DeviceMicrophone.class);
            deviceMicrophone.setDeviceBasicId(deviceBasic.getDeviceBasicId());
            deviceMicrophone.setDeviceMicrophoneId(IdUtil.getSuid());
            deviceMicrophoneDao.create(deviceMicrophone);

        }else if (deviceBasic.getDeviceBasicCategory().equals("cgqsb")){
            //保存传感器
            DeviceSensor deviceSensor = jsonObject.getObject("deviceSensor", DeviceSensor.class);
            deviceSensor.setDeviceBasicId(deviceBasic.getDeviceBasicId());
            deviceSensor.setDeviceSensorId(IdUtil.getSuid());
            deviceSensorDao.create(deviceSensor);
        }else if (deviceBasic.getDeviceBasicCategory().equals("dgsb")){
            //保存灯光
            DeviceLight deviceLight = jsonObject.getObject("deviceLight", DeviceLight.class);
            deviceLight.setDeviceBasicId(deviceBasic.getDeviceBasicId());
            deviceLight.setDeviceLightId(IdUtil.getSuid());
            deviceLightDao.create(deviceLight);
        }
        return deviceBasic.getDeviceBasicId();
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
