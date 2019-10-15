package com.dstz.device.core.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.core.util.StringUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.device.core.dao.*;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.manager.DeviceElaryWarningManager;
import com.dstz.device.core.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;

@Service("deviceElaryWarningManager")
public class DeviceElaryWarningManagerImpl extends BaseManager<String, DeviceElaryWarning> implements DeviceElaryWarningManager {


}
