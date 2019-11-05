package com.dstz.device.rest.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dstz.base.api.aop.annotion.CatchErr;
import com.dstz.base.api.constant.StringConstants;
import com.dstz.base.api.query.QueryFilter;
import com.dstz.base.api.response.impl.ResultMsg;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.db.model.page.PageResult;
import com.dstz.base.rest.BaseController;
import com.dstz.base.rest.util.ExcelUtiles;
import com.dstz.device.core.manager.*;
import com.dstz.device.core.model.*;
//import com.dstz.device.utils.ExcelUtiles;
import com.dstz.device.core.utils.SysLogUtils;
import com.dstz.org.api.model.IUser;
import com.dstz.security.login.context.LoginContext;
import com.dstz.device.utils.ParamUtil;
import com.dstz.sys.core.manager.DataDictManager;
import com.dstz.sys.core.model.DataDict;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Workbook;
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
 * 传感器报警<br/>
 * 
 * @author aschs
 *    
 */
@RestController
@RequestMapping("/elaryWarning/api/")
@Api(description = "传感器报警")
public class ElaryWarningController extends BaseController<DeviceElaryWarning> {
	@Resource
	DeviceElaryWarningManager deviceElaryWarningManager;
	@Resource
	SysLogManager sysLogManager;

    @Value("${fileUpload.rootSavePath}")
    private String rootSavePath;


	@Override
	protected String getModelDesc() {
		return "传感器报警";
	}

	/**
	 * 传感器报警列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	public PageResult listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginContext loginContext = new LoginContext();
		IUser iUser = loginContext.getCurrentUser();
		QueryFilter queryFilter = getQueryFilter(request);
		Page<DeviceElaryWarning> SerialNoList = (Page<DeviceElaryWarning>) deviceElaryWarningManager.query(queryFilter);
		try{
			sysLogManager.create(SysLogUtils.getSysLog(0,"","传感器报警列表", JSONObject.toJSONString(queryFilter.getParams())));
		}catch (Exception e){
			e.printStackTrace();
		}
		return new PageResult(SerialNoList);
	}

	/**
	 * 导出Excel数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/excel")
	public String excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter = getQueryFilter(request);
		queryFilter.setPage(null);
		List<DeviceElaryWarning> SerialNoList = deviceElaryWarningManager.query(queryFilter);

		String name="传感器报警";
		String excelName="传感器报警"+new SimpleDateFormat(StringConstants.DATE_FORMAT_DATE).format(new Date())+IdUtil.getSuid() +".xls";
		ExcelUtiles.exportExcel(SerialNoList, name, name, DeviceElaryWarning.class, rootSavePath+"excel/",excelName, response);
		String path =request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + "/upload/excel/"+excelName;
		try{
			sysLogManager.create(SysLogUtils.getSysLog(1,path,"传感器报警导出",JSONObject.toJSONString(queryFilter.getParams())));
		}catch (Exception e){
			e.printStackTrace();
		}
		return path;
	}



	/**
	 * 导入Excel
	 */
	@RequestMapping("/importExcel")
	public String importExcel(@RequestParam() MultipartFile file) {
		ImportParams importParams = new ImportParams();
		// 数据处理
		importParams.setHeadRows(1);
		importParams.setTitleRows(1);

		// 需要验证
		importParams.setNeedVerfiy(true);
		try {
			ExcelImportResult<DeviceElaryWarning> result = ExcelImportUtil.importExcelMore(file.getInputStream(), DeviceElaryWarning.class,
					importParams);

			List<DeviceElaryWarning> successList = result.getList();
			for (DeviceElaryWarning demoExcel : successList) {
				System.out.println(demoExcel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
