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
import com.dstz.device.config.Log;
import com.dstz.device.core.manager.*;
import com.dstz.device.core.model.*;
import com.dstz.device.core.utils.SysLogUtils;
import com.dstz.sys.core.manager.DataDictManager;
import com.dstz.sys.core.model.DataDict;
import com.github.pagehelper.Page;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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

	@Resource
	SysLogManager sysLogManager;

	@Value("${fileUpload.rootSavePath}")
	private String rootSavePath;


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
	@Log
	@RequestMapping("listJson")
	public PageResult listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter = getQueryFilter(request);
		System.out.println(IdUtil.getUId());
		Page<DeviceBasic> SerialNoList = (Page<DeviceBasic>) deviceBasicManager.query(queryFilter);
		try{
			sysLogManager.create(SysLogUtils.getSysLog(0,"","设备管理列表",JSONObject.toJSONString(queryFilter.getParams())));
		}catch (Exception e){
			e.printStackTrace();
		}
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

		String id = deviceBasicManager.createOrUpdateDevice(json);
		return getSuccessResult(id,"保存成功");
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

    }
	@RequestMapping("updateFile")
	@CatchErr("对设备操作失败")
	public ResultMsg<String> updateFile(@RequestParam(required = false) MultipartFile file,@RequestParam String id) throws Exception{

		DeviceBasic deviceBasic = deviceBasicManager.get(id);
		if (file!=null && !file.isEmpty()){
			deviceBasic.setDeviceBasicImg(getFileByte(file));
		}
		deviceBasicManager.update(deviceBasic);
		try{
			sysLogManager.create(SysLogUtils.getSysLog(0,"","更新设备图片信息",id));
		}catch (Exception e){
			e.printStackTrace();
		}
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

	@RequestMapping("uploadFileNew")
	public WangEditor uploadFileNew(@RequestParam("myFile") MultipartFile multipartFile,
								HttpServletRequest request) throws Exception {
		try {
			// 获取项目路径
			String realPath = request.getSession().getServletContext()
					.getRealPath("");
			InputStream inputStream = multipartFile.getInputStream();
			String contextPath = request.getContextPath();
			// 服务器根目录的路径
			//String path = "d:/images/";//realPath.replace(contextPath.substring(1), "");
			// 根目录下新建文件夹upload，存放上传图片
			//String uploadPath = rootSavePath + "upload";
			// 获取文件名称
			String filename = getFileName();
			// 将文件上传的服务器根目录下的upload文件夹
			File file = new File(rootSavePath, filename);
			FileUtils.copyInputStreamToFile(inputStream, file);
			// 返回图片访问路径
			String url = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + "/upload/" + filename;

			String[] str = { url };
			WangEditor we = new WangEditor(str);
			return we;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return  null;
	}
	public String getFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr = sdf.format(new Date());
		String str = RandomStringUtils.random(5,
				"abcdefghijklmnopqrstuvwxyz1234567890");
		String name = timeStr + str + ".jpg";
		return name;
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
