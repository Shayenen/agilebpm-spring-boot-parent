package com.dstz.device.core.dao;


import com.dstz.base.dao.BaseDao;
import com.dstz.device.core.model.DeviceMicrophone;
import com.dstz.device.core.model.DeviceSensor;

public interface DeviceMicrophoneDao extends BaseDao<String, DeviceMicrophone> {

    /**
     * 根据基础设备ID获取音频设备
     * @param basicId
     * @return
     */
    DeviceMicrophone getByDeviceBaiscId(String basicId);

    /**
     * 根据基础设备ID删除传音频设备
     * @param basicId
     */
    void  removeByBasicId(String basicId);
}