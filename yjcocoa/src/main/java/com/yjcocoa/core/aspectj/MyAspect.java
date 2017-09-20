package com.yjcocoa.core.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * MyAspect.java
 * <p>
 * Created by didi on 2017/9/14.
 * Copyright © 2017年 YJCocoa. All rights reserved.
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.yjcocoa.core.dao.*.*(..))")
    private void myPointCut() {}

    @Before("myPointCut()")
    public void myBefore(JoinPoint jointPoint) {
        System.out.print("前置通知");
    }

}
