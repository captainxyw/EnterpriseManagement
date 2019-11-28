package com.xuyewei.controller;

import com.xuyewei.domain.SysLog;
import com.xuyewei.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * ClassName:LogAop
 * Package:com.xuyewei.controller
 * Description:
 *
 * @Date:2019/11/28 21:22
 * @Author:xuyewei
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;
    private Class clazz;
    private Method method;

    @Before("execution(* com.xuyewei.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if(args == null || args.length == 0)
            method = clazz.getMethod(methodName);
        else {
            Class[] classArgs = new Class[args.length];
            for(int i=0; i<args.length; i++)
                classArgs[i] = args[i].getClass();
            clazz.getMethod(methodName, classArgs);
        }

    }

    @After("execution(* com.xuyewei.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        Long time = new Date().getTime() - visitTime.getTime();
        //获取URL
        String url = "";
        if(clazz != null && method != null && clazz != LogAop.class) {
            //获取类上的Annotation
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null) {
                String[] classValue = classAnnotation.value();

                //获取方法上的Annotation
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();

                    url =  classValue[0] + methodValue[0];
                }
            }


            //获取访问的IP
            String ip = request.getRemoteAddr();
            //获取当前操作的用户
            SecurityContext context = SecurityContextHolder.getContext();
            User user = (User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();



            //将日志相关信息封装
            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time);
            sysLog.setIp(ip);
            sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
            sysLog.setUrl(url);
            sysLog.setVisitTime(visitTime);
            sysLog.setUsername(username);

            //完成日志的记录
            sysLogService.save(sysLog);
        }


    }
}
