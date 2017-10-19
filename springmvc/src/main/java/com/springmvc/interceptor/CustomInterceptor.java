package com.springmvc.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CustomInterceptor.java
 * <p>
 * Created by 阳君 on 2017/10/19.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
public class CustomInterceptor implements HandlerInterceptor {

    // 控制器方法前执行，其返回值表示是否中断后续操作
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        System.out.println("preHandle: " + request.getServletPath());

        return true;
    }

    // 控制器方法调用之后，解析视图之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable
            ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle: " + request.getServletPath());
    }

    // 整个请求完成，视图渲染结束之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable
            Exception ex) throws Exception {
        System.out.println("afterCompletion: " + request.getServletPath());
    }
}