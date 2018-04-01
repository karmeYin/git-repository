package com.yin.girledemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {
    private static final Logger log= LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.yin.girledemo.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest=servletRequestAttributes.getRequest();
        //url
        log.info("url={}",httpServletRequest.getRequestURL());
        //method
        log.info("method={}",httpServletRequest.getMethod());
        //ip
        log.info("ip={}",httpServletRequest.getRemoteAddr());
        //类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        log.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        log.info("22222222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterRe(Object object){
        log.info("rsponse={}",object.toString());

    }

}
