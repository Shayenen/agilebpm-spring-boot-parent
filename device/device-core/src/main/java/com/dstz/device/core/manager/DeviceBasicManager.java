package com.dstz.device.core.manager;

import com.dstz.base.manager.Manager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;
import org.springframework.web.multipart.MultipartFile;

public interface DeviceBasicManager extends Manager<String, DeviceBasic> {

    /**
     * 视频设备保存
     * @param file
     * @param deviceBasic
     * @param deviceCamera
     */
    void createCamera(MultipartFile file, DeviceBasic deviceBasic, DeviceCamera deviceCamera) throws Exception;

    /**
     * 修改视频设备
     * @param file
     * @param deviceBasic
     * @param deviceCamera
     * @throws Exception
     */
    void updateCamera(MultipartFile file, DeviceBasic deviceBasic, DeviceCamera deviceCamera) throws Exception;

    /**
     * 摄像机详情
     * @param id
     * @return
     */
    DeviceCamera getDeviceCamera(String id);

    /**
     * 摄像机删除
     * @param basicId
     */
    void removeCamera(String basicId);
}
