package com.dstz.device.rest.controller;

import com.dstz.base.api.aop.annotion.CatchErr;
import com.dstz.base.api.constant.StringConstants;
import com.dstz.base.api.query.QueryFilter;
import com.dstz.base.api.response.impl.ResultMsg;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.core.util.StringUtil;
import com.dstz.base.db.model.page.PageResult;
import com.dstz.base.rest.BaseController;
import com.dstz.base.rest.util.ExcelUtiles;
import com.dstz.device.core.manager.DeviceWarningManager;
import com.dstz.device.core.manager.SysLogManager;
import com.dstz.device.core.model.DeviceWarning;
import com.dstz.device.core.model.SysLog;
import com.dstz.device.core.utils.SysLogUtils;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 系统操作日志<br/>
 * 
 * @author aschs
 *    
 */
@RestController
@RequestMapping("/sysLog/api/")
public class SysLogController extends BaseController<SysLog> {

    @Resource
    SysLogManager sysLogManager;

	@Value("${fileUpload.rootSavePath}")
	private String rootSavePath;


	@Override
	protected String getModelDesc() {
		return "操作日志";
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
		Page<SysLog> SerialNoList = (Page<SysLog>) sysLogManager.query(queryFilter);
		/*try{
			sysLogManager.create(SysLogUtils.getSysLog(0,"","设备故障管理列表"));
		}catch (Exception e){
			e.printStackTrace();
		}*/
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
		List<SysLog> SerialNoList = sysLogManager.query(queryFilter);
		String name="操作日志";
		String excelName="操作日志"+new SimpleDateFormat(StringConstants.DATE_FORMAT_DATE).format(new Date())+ IdUtil.getSuid() +".xls";
        ExcelUtiles.exportExcel(SerialNoList, name, name, DeviceWarning.class, rootSavePath+"excel/",excelName, response);
		String path =request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + "/upload/excel/"+excelName;
        try{
			sysLogManager.create(SysLogUtils.getSysLog(1,path,"操作日志导出",queryFilter.getWhereSql()));
		}catch (Exception e){
			e.printStackTrace();
		}
        return path;
	}


}
