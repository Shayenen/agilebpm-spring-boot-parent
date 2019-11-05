package com.dstz.device.rest.controller;

import com.alibaba.fastjson.JSONObject;
import com.dstz.base.api.constant.StringConstants;
import com.dstz.base.api.query.QueryFilter;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.db.model.page.PageResult;
import com.dstz.base.rest.BaseController;
import com.dstz.base.rest.util.ExcelUtiles;
import com.dstz.device.core.manager.DeviceElaryWarningManager;
import com.dstz.device.core.manager.DeviceWarningManager;
import com.dstz.device.core.manager.SysLogManager;
import com.dstz.device.core.model.DeviceBasic;
import com.dstz.device.core.model.DeviceElaryWarning;
import com.dstz.device.core.model.DeviceWarning;
//import com.dstz.device.utils.ExcelUtiles;
import com.dstz.device.core.utils.SysLogUtils;
import com.dstz.device.utils.ParamUtil;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 设备故障管理<br/>
 * 
 * @author aschs
 *    
 */
@RestController
@RequestMapping("/basicWarning/api/")
@Api(description = "设备故障管理")
public class DeviceWarningController extends BaseController<DeviceWarning> {
	@Resource
	DeviceWarningManager deviceWarningManager;
    @Value("${fileUpload.rootSavePath}")
    private String rootSavePath;

    @Resource
    SysLogManager sysLogManager;


	@Override
	protected String getModelDesc() {
		return "设备故障管理";
	}

	/**
	 * 设备故障管理列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	public PageResult listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter = getQueryFilter(request);
		Page<DeviceWarning> SerialNoList = (Page<DeviceWarning>) deviceWarningManager.query(queryFilter);
		try{
			sysLogManager.create(SysLogUtils.getSysLog(0,"","设备故障管理列表",JSONObject.toJSONString(queryFilter.getParams())));
		}catch (Exception e){
			e.printStackTrace();
		}
		return new PageResult(SerialNoList);
	}

	/**
	 * 导出excel
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/excel")
	public String excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter = getQueryFilter(request);
		queryFilter.setPage(null);
		List<DeviceWarning> SerialNoList = deviceWarningManager.query(queryFilter);
		String name="视频故障报警";
		String excelName="视频故障报警"+new SimpleDateFormat(StringConstants.DATE_FORMAT_DATE).format(new Date())+ IdUtil.getSuid() +".xls";
        ExcelUtiles.exportExcel(SerialNoList, name, name, DeviceWarning.class, rootSavePath+"excel/",excelName, response);
		String path =request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + "/upload/excel/"+excelName;
        try{
			sysLogManager.create(SysLogUtils.getSysLog(1,path,"设备故障导出", JSONObject.toJSONString(queryFilter.getParams())));
		}catch (Exception e){
			e.printStackTrace();
		}
        return path;
	}


}
