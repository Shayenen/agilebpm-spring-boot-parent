package com.dstz.device.core.dao;


import com.dstz.base.dao.BaseDao;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;

public interface DeviceCameraDao extends BaseDao<String, DeviceCamera> {

    DeviceCamera getByDeviceBaiscId(String basicId);

    void  removeByBasicId(String basicId);
}