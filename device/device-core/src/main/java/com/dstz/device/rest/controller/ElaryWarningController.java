package com.dstz.device.rest.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dstz.base.api.aop.annotion.CatchErr;
import com.dstz.base.api.query.QueryFilter;
import com.dstz.base.api.response.impl.ResultMsg;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.db.model.page.PageResult;
import com.dstz.base.rest.BaseController;
import com.dstz.device.core.manager.*;
import com.dstz.device.core.model.*;
import com.dstz.sys.core.manager.DataDictManager;
import com.dstz.sys.core.model.DataDict;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
 * 预警管理<br/>
 * 
 * @author aschs
 *    
 */
@RestController
@RequestMapping("/elaryWarning/api/")
@Api(description = "预警管理")
public class ElaryWarningController extends BaseController<DeviceBasic> {
	@Resource
	DeviceElaryWarningManager deviceElaryWarningManager;



	@Override
	protected String getModelDesc() {
		return "预警管理";
	}

	/**
	 * 预警管理列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	public PageResult listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter = getQueryFilter(request);
		Page<DeviceElaryWarning> SerialNoList = (Page<DeviceElaryWarning>) deviceElaryWarningManager.query(queryFilter);
		return new PageResult(SerialNoList);
	}
	@RequestMapping("/listJson2")
	public PageResult listJson2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter = getQueryFilter(request);
		Page<DeviceElaryWarning> SerialNoList = (Page<DeviceElaryWarning>) deviceElaryWarningManager.query(queryFilter);
		return new PageResult(SerialNoList);
	}


}
