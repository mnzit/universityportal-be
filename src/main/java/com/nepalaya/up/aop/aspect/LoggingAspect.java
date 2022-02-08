package com.nepalaya.up.aop.aspect;

import com.nepalaya.up.util.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(com.nepalaya.up.aop.aspect.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        Method method = methodSignature.getMethod();
        LogUtil.info("Executing method : {}", method.getName());
        Object object = joinPoint.proceed();
        LogUtil.info("Completed executing method : {}", method.getName());
        return object;
    }
}