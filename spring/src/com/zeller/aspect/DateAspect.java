package com.zeller.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Date;
@Aspect
@Component
public class DateAspect {
    @Around(value = "execution(* com.zeller.service.ProductService.*(..))")
    public Object logDate(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start date:" + new Date().toString());
        Object object = joinPoint.proceed();
        System.out.println("end date:" + new Date().toString());
        return object;
    }
}
