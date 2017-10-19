package com.springmvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

/**
 * AOPAspect.java
 * <p>
 * Created by 阳君 on 2017/10/18.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Aspect
@Component
public class AOPAspect {

//    @Pointcut("execution(* com.springmvc.dao.*.* (..))")
//    @Pointcut("within(com.springmvc.dao.*)")
//    @Pointcut("execution(void addUser())")
    @Pointcut("this(com.springmvc.dao.UserDao)")
    private void pointCut() {
    }

    // 环绕通知
    @Around("pointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 开始
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务...");
        // 执行当前目标方法
        Object obj = proceedingJoinPoint.proceed();
        // 结束
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务...");
        return obj;
    }

    // 前置通知
    @Before("pointCut()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.print("前置通知 ：模拟执行权限检查...,");
        System.out.print("目标类是：" + joinPoint.getTarget());
        System.out.println(",被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    // 异常通知
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：出错了" + e.getMessage());
    }

    // 后置 final 通知
    @After("pointCut()")
    public void myAfter() {
        System.out.println("后置 final 通知：模拟方法结束后的释放资源...");
    }

    // 后置通知
    @AfterReturning(value = "pointCut()")
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.print("后置通知：模拟记录日志...,");
        System.out.println("被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

}


