package com.dstz.device.rest.controller;

import com.dstz.base.api.aop.annotion.CatchErr;
import com.dstz.base.api.query.QueryFilter;
import com.dstz.base.api.response.impl.ResultMsg;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.core.util.StringUtil;
import com.dstz.base.db.model.page.PageResult;
import com.dstz.base.rest.BaseController;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceCamera;
import com.github.pagehelper.Page;
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
		System.out.println("--------------------------------进入demo测试");
		QueryFilter queryFilter = getQueryFilter(request);
		System.out.println(IdUtil.getUId());
		Page<DeviceBasic> SerialNoList = (Page<DeviceBasic>) deviceBasicManager.query(queryFilter);
		return new PageResult(SerialNoList);
	}

	/**
	 * 新增修改设备信息
	 * @param deviceBasic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveDeviceCamera")
	@CatchErr("对设备操作失败")
	public ResultMsg<String> saveDeviceCamera(@RequestBody DeviceBasic deviceBasic) throws Exception{

		String id=deviceBasic.getId();
		if(StringUtil.isEmpty(id)){
			DeviceCamera deviceCamera =new DeviceCamera();
			deviceBasicManager.createCamera(deviceBasic.getFile(),deviceBasic,deviceCamera);
			return  getSuccessResult("添加demo成功");
		}else{
			DeviceCamera deviceCamera =new DeviceCamera();
			deviceBasicManager.updateCamera(deviceBasic.getFile(),deviceBasic,deviceCamera);
			return  getSuccessResult("更新demo成功");
		}
	}

	/**
	 * 获取设备信息详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getCameraInfo")
	public ResultMsg<Map> getCameraInfo(@RequestParam String id) throws Exception {

		DeviceBasic deviceBasic = deviceBasicManager.get(id);
		Map resultMap = new HashMap();
		resultMap.put("deviceBasic",deviceBasic);

		DeviceCamera deviceCamera = deviceBasicManager.getDeviceCamera(id);

		resultMap.put("deviceCamera",deviceCamera);
		return  getSuccessResult(resultMap);
	}

	/**
	 * 删除设备信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"removeCamera"})
	@CatchErr
	public ResultMsg<String> removeCamera(@RequestParam String id) throws Exception {
		deviceBasicManager.removeCamera(id);
		return this.getSuccessResult(String.format("删除%s成功", this.getModelDesc()));
	}




}
