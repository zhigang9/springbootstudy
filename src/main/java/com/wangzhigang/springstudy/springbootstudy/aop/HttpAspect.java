package com.wangzhigang.springstudy.springbootstudy.aop;


import com.wangzhigang.springstudy.springbootstudy.exceptions.ExceptionHandle;
import com.wangzhigang.springstudy.springbootstudy.response.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Pointcut("execution(public * com.wangzhigang.springstudy.springbootstudy.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("url = " + request.getRequestURL());
        LOGGER.info("method = " + request.getMethod());
        LOGGER.info("ip = " + request.getRemoteAddr());
        LOGGER.info("class_method = " + joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        LOGGER.info("args = " + joinPoint.getArgs());

    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Result result = null;

        try{


        }catch (Exception e)
        {
            return exceptionHandle.exceptionGet(e);
        }

        if(result == null){
            return proceedingJoinPoint.proceed();
        }
        else {
            return result;
        }
    }


    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterReturing(Object object){
        LOGGER.info("response =" + object.toString());
    }

}
