package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * StudentBean.java
 * <p>
 * Created by didi on 2017/10/13.
 * Copyright © 2017年 bean. All rights reserved.
 */
public class StudentBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    private String name;

    private String beanName;//实现了BeanNameAware接口，Spring可以将BeanName注入该属性中


    public StudentBean() {
        System.out.println("【Bean构造方法】无参构造方法");
    }

    @Override
    public String toString() {
        return "StudentBean{name='" + name + ", beanName='" + beanName + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【set注入】注入属性");
        this.name = name;
    }

    // ------------------------------ BeanNameAware接口
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("【BeanNameAware】setBeanName:" + name);
    }

    // ------------------------------ BeanFactoryAware接口
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware】setBeanFactory 方法得到 beanFactory 引用");
    }

    // ------------------------------ ApplicationContextAware 接口
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("【ApplicationContextAware】setApplicationContext 方法得到 applicationContext 引用");
    }

    // ----------------------------------------------------------------- 初始化
    // ------------------------------ 注解初始化方法
    @PostConstruct
    public void jsrInit() {
        System.out.println("【@PostConstruct】调用 @PostConstruct 初始化方法");
    }

    // ------------------------------ InitializingBean接口
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean】afterPropertiesSet 初始化");
    }

    // ------------------------------ xml定制初始化方法
    public void xmlInit() {
        System.out.println("【init-method】调用init-method属性配置的初始化方法");
    }


    // ----------------------------------------------------------------- 销毁
    // ------------------------------ 注解销毁方法
    @PreDestroy
    public void jsrDestroy() {
        System.out.println("【@PreDestroy】调用 @PreDestroy 销毁方法");
    }

    // ------------------------------ DisposableBean接口
    public void destroy() throws Exception {
        System.out.println("【DisposableBean】destroy");
    }

    // ------------------------------ xml定制销毁方法
    public void xmlDestroy() {
        System.out.println("【destroy-method】调用destroy-method属性配置的销毁方法");
    }

}
