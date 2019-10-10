package com.dstz.device.core.dao;


import com.dstz.base.dao.BaseDao;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;

public interface DeviceCameraDao extends BaseDao<String, DeviceCamera> {

    /**
     * 根据基础设备ID获取视频监控
     * @param basicId
     * @return
     */
    DeviceCamera getByDeviceBaiscId(String basicId);

    /**
     * 根据基础设备ID删除视频监控信息
     * @param basicId
     */
    void  removeByBasicId(String basicId);
}