package com.dstz.device.rest.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dstz.base.api.aop.annotion.CatchErr;
import com.dstz.base.api.query.QueryFilter;
import com.dstz.base.api.response.impl.ResultMsg;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.core.util.StringUtil;
import com.dstz.base.db.model.page.PageResult;
import com.dstz.base.rest.BaseController;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.manager.DeviceLightManager;
import com.dstz.device.core.manager.DeviceMicrophoneManager;
import com.dstz.device.core.manager.DeviceSensorManager;
import com.dstz.device.core.model.*;
import com.github.pagehelper.Page;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 设备管理 控制器类<br/>
 * 
 * @author aschs
 *    
 */
@RestController
@RequestMapping("/basedevice/api/")
@Api(description = "基础设备管理")
public class BaseDeviceController extends BaseController<DeviceBasic> {
	@Resource
	DeviceBasicManager deviceBasicManager;
	@Resource
	DeviceLightManager deviceLightManager;
	@Resource
	DeviceMicrophoneManager deviceMicrophoneManager;
	@Resource
	DeviceSensorManager deviceSensorManager;

	@Override
	protected String getModelDesc() {
		return "设备管理";
	}

	/**
	 * 设备管理列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	public PageResult listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter = getQueryFilter(request);
		System.out.println(IdUtil.getUId());
		Page<DeviceBasic> SerialNoList = (Page<DeviceBasic>) deviceBasicManager.query(queryFilter);
		return new PageResult(SerialNoList);
	}

	/**
	 * 新增修改设备信息
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveDeviceCamera")
	@CatchErr("对设备操作失败")
	public ResultMsg<String> saveDeviceCamera(@RequestBody String json) throws Exception{

		JSONObject jsonObject = JSON.parseObject(json);
		//  在转成不同的实体类
		DeviceBasic user = jsonObject.getObject("deviceBasic", DeviceBasic.class);

		/*String id=deviceBasic.getId();
		if(StringUtil.isEmpty(id)){
			DeviceCamera deviceCamera =new DeviceCamera();
			deviceBasicManager.createCamera(deviceBasic.getFile(),deviceBasic,deviceCamera);
			return  getSuccessResult("添加设备信息成功");
		}else{
			DeviceCamera deviceCamera =new DeviceCamera();
			deviceBasicManager.updateCamera(deviceBasic.getFile(),deviceBasic,deviceCamera);
			return  getSuccessResult("更新设备信息成功");
		}*/
		return getSuccessResult();
	}

	/**
	 * 获取设备信息详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getDeviceInfo")
	public ResultMsg<Map> getDeviceInfo(@RequestParam String id) throws Exception {

		DeviceBasic deviceBasic = deviceBasicManager.get(id);
		Map resultMap = new HashMap();
		if (deviceBasic == null){
			resultMap.put("deviceType","error");
			return  getSuccessResult(resultMap);
		}

		resultMap.put("deviceBasic",deviceBasic);
		if (deviceBasic.getDeviceBasicCategory().equals("spjksb")) {
			//视频
			resultMap.put("deviceType","spjksb");
			DeviceCamera deviceCamera = deviceBasicManager.getDeviceCamera(id);
			resultMap.put("deviceCamera", deviceCamera);
		}else if (deviceBasic.getDeviceBasicCategory().equals("ypsb")){
			//音频设备
			resultMap.put("deviceType","ypsb");
			DeviceMicrophone deviceMicrophone = deviceMicrophoneManager.getDeviceMicrophone(id);
			resultMap.put("deviceMicrophone", deviceMicrophone);

		}else if (deviceBasic.getDeviceBasicCategory().equals("cgqsb")){
			//传感器设备
			resultMap.put("deviceType","cgqsb");
			DeviceSensor deviceSensor = deviceSensorManager.getDeviceSensor(id);
			resultMap.put("deviceSensor", deviceSensor);

		}else if (deviceBasic.getDeviceBasicCategory().equals("dgsb")){
			//灯光设备
			resultMap.put("deviceType","dgsb");
			DeviceLight deviceLight = deviceLightManager.getDeviceLight(id);
			resultMap.put("deviceLight", deviceLight);
		}else{
			resultMap.put("deviceType","other");
		}
		return  getSuccessResult(resultMap);
	}

	/**
	 * 删除设备信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"removeDevice"})
	@CatchErr
	public ResultMsg<String> removeDevice(@RequestParam String id) throws Exception {
		deviceBasicManager.removeDevice(id);
		return this.getSuccessResult(String.format("删除%s成功", this.getModelDesc()));
	}
}
