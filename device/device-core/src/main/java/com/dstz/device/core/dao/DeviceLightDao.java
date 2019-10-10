package com.dstz.device.core.dao;


import com.dstz.base.dao.BaseDao;
import com.dstz.device.core.model.DeviceCamera;
import com.dstz.device.core.model.DeviceLight;

public interface DeviceLightDao extends BaseDao<String, DeviceLight> {

    /**
     * 根据基础设备ID获取灯光监控
     * @param basicId
     * @return
     */
    DeviceLight getByDeviceBaiscId(String basicId);

    /**
     * 根据基础设备ID删除灯光监控信息
     * @param basicId
     */
    void  removeByBasicId(String basicId);
}