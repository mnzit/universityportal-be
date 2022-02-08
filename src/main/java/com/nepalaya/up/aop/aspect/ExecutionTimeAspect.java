package com.nepalaya.up.aop.aspect;

import com.nepalaya.up.util.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Component
@Aspect
public class ExecutionTimeAspect {

    @Around("@annotation(com.nepalaya.up.aop.aspect.LogExecutionTime) || @annotation(org.springframework.stereotype.Repository)")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        Method method = methodSignature.getMethod();
        LogUtil.info("Executing method : {}", method.getName());
        LogUtil.info("{}->{}", signature.getDeclaringTypeName(), method.getName());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object = proceedingJoinPoint.proceed();
        stopWatch.stop();
        LogUtil.info(stopWatch.prettyPrint());
        LogUtil.info("Time taken in millis: {}", stopWatch.getTotalTimeMillis());
        return object;
    }
}