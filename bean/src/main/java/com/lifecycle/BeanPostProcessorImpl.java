package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * BeanPostProcessorImpl.java
 * <p>
 * Created by didi on 2017/10/13.
 * Copyright © 2017年 bean. All rights reserved.
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {

    // ------------------------------ BeanPostProcessor 接口
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【BeanPostProcessor】postProcessBeforeInitialization 前置初始化 " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【BeanPostProcessor】postProcessAfterInitialization 后置初始化 " + beanName);
        return bean;
    }
}
