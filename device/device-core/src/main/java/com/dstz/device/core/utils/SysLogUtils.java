package com.dstz.device.core.utils;

import com.alibaba.fastjson.JSON;
import com.dstz.base.core.id.IdUtil;
import com.dstz.base.core.util.RequestContext;
import com.dstz.base.core.util.StringUtil;
import com.dstz.base.rest.util.IPAddressUtil;
import com.dstz.base.rest.util.RequestUtil;
import com.dstz.device.core.model.SysLog;
import com.dstz.org.api.model.IUser;
import com.dstz.sys.core.model.LogErr;
import com.dstz.sys.util.ContextUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class SysLogUtils {

    public static SysLog getSysLog(int isFile,String fileAddress,String context,String param){
        IUser sysUser = ContextUtil.getCurrentUser();
        SysLog logErr = new SysLog();
        String account = "未知用户";
        if (sysUser != null) {
            logErr.setOperator(sysUser.getAccount());
            logErr.setOperatorId(sysUser.getUserId());
            logErr.setOperatorName(sysUser.getFullname());

        }else {
            logErr.setOperator(account);
            logErr.setOperatorName(account);
        }
        HttpServletRequest request =  RequestContext.getHttpServletRequest();

        logErr.setId(IdUtil.getSuid());
        logErr.setIp(RequestUtil.getIpAddr(request));
        logErr.setIsFile(isFile);
        logErr.setFileAddress(fileAddress);
        logErr.setOperatorContext(context);

        if(StringUtil.isNotEmpty(logErr.getIp())) {
            try {
                logErr.setIpAddress(IPAddressUtil.getAddresses(logErr.getIp()));
            } catch (UnsupportedEncodingException e) {
            }
        }
        String requestParam = JSON.toJSONString(request.getParameterMap());
       /* if(StringUtils.isEmpty(requestParam) || requestParam.length()<3) {
            requestParam = "";
            for(Object o: point.getArgs()) {
                if(o instanceof ServletRequest || o instanceof ServletResponse) continue;
                requestParam += JSON.toJSONString(o);
            }
        }*/
       /*if(StringUtils.isBlank(param)) {
           logErr.setRequestContext(requestParam);
       }else{*/
           logErr.setRequestContext(param);
       //}
        logErr.setCreateTime(new Date());

        return logErr;
    }
}
