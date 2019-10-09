package com.dstz.device.rest.controller;

import com.dstz.base.api.query.QueryFilter;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.db.model.page.PageResult;
import com.dstz.base.rest.BaseController;
import com.dstz.device.core.manager.DeviceBasicManager;
import com.dstz.device.core.model.DeviceBasic;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


	@RequestMapping("listJson")
	public PageResult listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("--------------------------------进入demo测试");
		QueryFilter queryFilter = getQueryFilter(request);
		System.out.println(IdUtil.getUId());
		Page<DeviceBasic> SerialNoList = (Page<DeviceBasic>) deviceBasicManager.query(queryFilter);
		return new PageResult(SerialNoList);
	}

	/*@RequestMapping("save")
	@CatchErr("对demo操作失败")
	public ResultMsg<String> save(@RequestBody Demo demo) throws Exception{

		String id=demo.getId();
		if(StringUtil.isEmpty(id)){

			demo.setId(IdUtil.getSuid());
			demoManager.create(demo);
			return  getSuccessResult("添加demo成功");
		}else{
			demoManager.update(demo);
			return  getSuccessResult("更新demo成功");
		}
	}


*/



}
