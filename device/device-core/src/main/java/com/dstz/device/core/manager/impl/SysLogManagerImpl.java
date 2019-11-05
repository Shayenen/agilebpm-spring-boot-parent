package com.dstz.device.core.manager.impl;

import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.manager.DeviceWarningManager;
import com.dstz.device.core.manager.SysLogManager;
import com.dstz.device.core.model.DeviceWarning;
import com.dstz.device.core.model.SysLog;
import org.springframework.stereotype.Service;

@Service("sysLogManager")
public class SysLogManagerImpl extends BaseManager<String, SysLog> implements SysLogManager {


}
