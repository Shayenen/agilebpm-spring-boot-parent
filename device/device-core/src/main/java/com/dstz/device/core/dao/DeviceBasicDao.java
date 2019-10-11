package com.dstz.device.core.dao;


import com.dstz.base.dao.BaseDao;
import com.dstz.device.core.model.DeviceBasic;

import java.util.Map;

public interface DeviceBasicDao extends BaseDao<String, DeviceBasic> {
        Map getMap(String id);
}