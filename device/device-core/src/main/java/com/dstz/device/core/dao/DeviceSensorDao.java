package com.dstz.device.core.dao;


import com.dstz.base.dao.BaseDao;
import com.dstz.device.core.model.DeviceLight;
import com.dstz.device.core.model.DeviceSensor;

public interface DeviceSensorDao extends BaseDao<String, DeviceSensor> {

    /**
     * 根据基础设备ID获取传感器设备
     * @param basicId
     * @return
     */
    DeviceSensor getByDeviceBaiscId(String basicId);

    /**
     * 根据基础设备ID删除传感器监控信息
     * @param basicId
     */
    void  removeByBasicId(String basicId);
}