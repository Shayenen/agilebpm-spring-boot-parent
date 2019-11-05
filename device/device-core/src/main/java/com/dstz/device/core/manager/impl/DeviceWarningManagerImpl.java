package com.dstz.device.core.manager.impl;

import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.DeviceSensorDao;
import com.dstz.device.core.manager.DeviceSensorManager;
import com.dstz.device.core.manager.DeviceWarningManager;
import com.dstz.device.core.model.DeviceSensor;
import com.dstz.device.core.model.DeviceWarning;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("deviceWarningManager")
public class DeviceWarningManagerImpl extends BaseManager<String, DeviceWarning> implements DeviceWarningManager {


}
