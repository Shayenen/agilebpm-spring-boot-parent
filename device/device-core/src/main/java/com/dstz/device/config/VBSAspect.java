package com.dstz.device.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
@Aspect
@Component
public class VBSAspect {
    private static final Logger log= LoggerFactory.getLogger(VBSAspect.class);

    @Pointcut("@annotation(com.dstz.device.config.Log)")
    public void logPointcut(){}

    @Around("logPointcut()")
    public Object logHandler(ProceedingJoinPoint process) throws Throwable{
        long startTime=System.currentTimeMillis();
        MethodSignature methodSignature= (MethodSignature) process.getSignature();
        Method method=methodSignature.getMethod();
        String methodName=method.getName();
        String className= method.getDeclaringClass().getName();
        Object[] args=process.getArgs();
        StringBuilder params=new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            params.append(args[i].toString());
            params.append(";");
        }
        Object result= null;
        try {
            result = process.proceed();
        } catch (Throwable throwable) {
            String exception=throwable.getClass()+":"+throwable.getMessage();
            long costTime=System.currentTimeMillis()-startTime;
            log.error("请求时间：{}，请求耗时：{}，请求类名：{}，请求方法：{}，请求参数:{}，请求结果：{}",startTime,costTime,className,methodName,params.toString(),exception);
            return result;//CustomerResponse.buildFail(throwable.getMessage());
        }
        long costTime=System.currentTimeMillis()-startTime;
        log.info("请求时间：{}，请求耗时：{}，请求类名：{}，请求方法：{}，请求参数:{}，请求结果：{}",startTime,costTime,className,methodName,params.toString(), result);
        return result;
    }
}

*/
