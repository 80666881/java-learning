package com.zeller.aspect;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

public class DateAspect {
    public Object logDate(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start date:" + new Date().toString());
        Object object = joinPoint.proceed();
        System.out.println("end date:" + new Date().toString());
        return object;
    }
}
