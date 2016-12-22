package com.property.feedback.profiler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by hojha on 13/12/16.
 */
@Aspect
@Component
public class ExecutionTimeProfiler {

    @Pointcut("execution(* com.property.feedback.service.PropertyService.findAllProperties(..))")
    public void findAllProperties() {
    }

    @Around("findAllProperties()")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object retVal = proceedingJoinPoint.proceed();
        System.out.println("Total time to execute : " + (System.currentTimeMillis() - startTime) + " ms");
        return retVal;
    }
}
