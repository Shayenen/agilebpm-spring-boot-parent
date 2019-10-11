package com.dstz.device.rest.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
import com.dstz.sys.core.manager.DataDictManager;
import com.dstz.sys.core.model.DataDict;
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
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.dstz.device.core.utils.FileUtils.getFileByte;

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

	@Resource
	DataDictManager dataDictManager;


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
		DeviceBasic deviceBasic = jsonObject.getObject("deviceBasic", DeviceBasic.class);

		String id=deviceBasic.getId();
		if(StringUtil.isEmpty(id)){
			deviceBasic.setDeviceBasicId(IdUtil.getSuid());
			if (deviceBasic.getDeviceBasicCategory().equals("spjksb")) {
				DeviceCamera deviceCamera = jsonObject.getObject("deviceCamera", DeviceCamera.class);
				deviceBasicManager.createCamera(deviceBasic.getFile(), deviceBasic, deviceCamera);
				return getSuccessResult(deviceBasic.getDeviceBasicId(), "添加视频监控信息成功");
			}else if (deviceBasic.getDeviceBasicCategory().equals("ypsb")){
				DeviceMicrophone deviceMicrophone = jsonObject.getObject("deviceMicrophone", DeviceMicrophone.class);
				deviceMicrophoneManager.createMicrophone(deviceBasic.getFile(), deviceBasic,deviceMicrophone);
				return getSuccessResult(deviceBasic.getDeviceBasicId(), "添加音频信息成功");
			}else if (deviceBasic.getDeviceBasicCategory().equals("cgqsb")){
				DeviceSensor deviceSensor = jsonObject.getObject("deviceSensor", DeviceSensor.class);
				deviceSensorManager.createSensor(deviceBasic.getFile(), deviceBasic,deviceSensor);
				return getSuccessResult(deviceBasic.getDeviceBasicId(), "添加传感器信息成功");
			}else if (deviceBasic.getDeviceBasicCategory().equals("dgsb")){
				DeviceLight deviceLight = jsonObject.getObject("deviceLight", DeviceLight.class);
				deviceLightManager.createLight(deviceBasic.getFile(), deviceBasic,deviceLight);
				return getSuccessResult(deviceBasic.getDeviceBasicId(), "添加灯光信息成功");
			}
		}else{
			if (deviceBasic.getDeviceBasicCategory().equals("spjksb")) {
				DeviceCamera deviceCamera = jsonObject.getObject("deviceCamera", DeviceCamera.class);
				deviceBasicManager.updateCamera(deviceBasic.getFile(), deviceBasic, deviceCamera);
				return getSuccessResult("更新视频监控信息成功");
			}else if (deviceBasic.getDeviceBasicCategory().equals("ypsb")){
				DeviceMicrophone deviceMicrophone = jsonObject.getObject("deviceMicrophone", DeviceMicrophone.class);
				deviceMicrophoneManager.updateMicrophone(deviceBasic.getFile(), deviceBasic, deviceMicrophone);
				return getSuccessResult("更新音频信息成功");
			}else if (deviceBasic.getDeviceBasicCategory().equals("cgqsb")){
				DeviceSensor deviceSensor = jsonObject.getObject("deviceSensor", DeviceSensor.class);
				deviceSensorManager.updateSensor(deviceBasic.getFile(), deviceBasic,deviceSensor);
				return getSuccessResult("更新传感器信息成功");
			}else if (deviceBasic.getDeviceBasicCategory().equals("dgsb")){
				DeviceLight deviceLight = jsonObject.getObject("deviceLight", DeviceLight.class);
				deviceLightManager.updateLight(deviceBasic.getFile(), deviceBasic,deviceLight);
				return getSuccessResult("更新灯光信息成功");
			}
		}
		return getWarnResult("位置错误");
	}
	@RequestMapping(value="/getFileById")
	public void getPhotoById (@RequestParam("id") String id, final HttpServletResponse response) throws Exception{
		Map map = deviceBasicManager.getMap(id);
		//DeviceBasic deviceBasic = deviceBasicManager.get(id);
		if(map!=null && map.size()>0 && map.get("device_basic_img")!=null) {
			byte[] data = (byte[]) map.get("device_basic_img");
			response.setContentType("image/jpeg");
			response.setCharacterEncoding("UTF-8");
			OutputStream outputSream = response.getOutputStream();
			outputSream.write(data);
			outputSream.flush();
		}
        /*InputStream in = new ByteArrayInputStream(data);
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = in.read(buf, 0, 1024)) != -1) {
            outputSream.write(buf, 0, len);
        }
        outputSream.close(); */
    }
	@RequestMapping("updateFile")
	@CatchErr("对设备操作失败")
	public ResultMsg<String> updateFile(@RequestParam(required = false) MultipartFile file,@RequestParam String id) throws Exception{

		DeviceBasic deviceBasic = deviceBasicManager.get(id);
		if (file!=null && !file.isEmpty()){
			deviceBasic.setDeviceBasicImg(getFileByte(file));
		}
		deviceBasicManager.update(deviceBasic);
		return  getSuccessResult("图片更新信息成功");
	}

	/**
	 * 获取视频子设备信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getDeviceCameraInfo")
	public ResultMsg<DeviceCamera> getDeviceCameraInfo(@RequestParam String id) throws Exception {
		DeviceCamera deviceCamera = deviceBasicManager.getDeviceCamera(id);
		return  getSuccessResult(deviceCamera);
	}
	/**
	 * 获取音频子设备信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getDeviceMicrophoneInfo")
	public ResultMsg<DeviceMicrophone> getDeviceMicrophoneInfo(@RequestParam String id) throws Exception {


			DeviceMicrophone deviceMicrophone = deviceMicrophoneManager.getDeviceMicrophone(id);

		return  getSuccessResult(deviceMicrophone);
	}
	/**
	 * 获取传感器子设备信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getDeviceSensorInfo")
	public ResultMsg<DeviceSensor> getDeviceSensorInfo(@RequestParam String id) throws Exception {

			DeviceSensor deviceSensor = deviceSensorManager.getDeviceSensor(id);

		return  getSuccessResult(deviceSensor);
	}
	/**
	 * 获取视频子设备信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getDeviceLightInfo")
	public ResultMsg<DeviceLight> getDeviceLightInfo(@RequestParam String id) throws Exception {
		DeviceLight deviceLight = deviceLightManager.getDeviceLight(id);

		return  getSuccessResult(deviceLight);
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

	@RequestMapping("getDictData")
	public ResultMsg<Map> getByDictKey(@RequestParam(value = "dictKey[]") String[] dictKey, @RequestParam(defaultValue="false") Boolean hasRoot) throws Exception{
		if(dictKey.length==0) return null;
		Map map = new HashMap();
		for (int i=0;i<dictKey.length;i++){
			List<DataDict> dict = dataDictManager.getDictNodeList(dictKey[i],hasRoot);
			map.put(dictKey[i],dict);
		}

		return getSuccessResult(map);
	}

	@RequestMapping("getTestData")
	public JSON getTestData() {

		String json = "[[\"product\", \"视频监控设备\", \"音频设备\", \"传感器设备\"]," // 产品项
				+ "[\"2015\"," + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "], [\"2016\", " + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "],"
				+ "[\"2017\", " + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "], [\"2018\"," + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + "]]";
		JSONArray jsonArray = JSONArray.parseArray(json);

		return jsonArray;
	}
	private int getRandomInt() {
		Random rand = new Random();
		return rand.nextInt(6000);
	}
}
