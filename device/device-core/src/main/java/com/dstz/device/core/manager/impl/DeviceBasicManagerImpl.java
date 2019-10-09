package com.dstz.device.core.manager.impl;

import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.DeviceBasicDao;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.model.DeviceBasic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("deviceBasicManager")
public class DeviceBasicManagerImpl  extends BaseManager<String, DeviceBasic> implements DeviceBasicManager {
    @Resource
    DeviceBasicDao deviceBasicDao;

}
