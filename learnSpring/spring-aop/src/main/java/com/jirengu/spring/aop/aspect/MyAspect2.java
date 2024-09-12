package com.jirengu.spring.aop.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect2 {

    @Before("generalPointCut()")
    public void beforex() {
        System.out.println("独立的通知");
    }


    @Pointcut("@annotation(com.jirengu.spring.aop.annotation.An2)")
    public void generalPointCut() {

    }
}
