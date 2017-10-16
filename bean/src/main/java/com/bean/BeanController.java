package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * BeanController.java
 * <p>
 * Created by didi on 2017/9/29.
 * Copyright © 2017年 bean. All rights reserved.
 */
@Component
public class BeanController {

    @Autowired
    private BeanService service;

    @Resource(name = "com.bean.BeanServiceImpl2")
    private BeanService service2;

    @Autowired
    private BeanServiceImpl3 service3;

    @Resource(name = "BeanServiceImpl3", type = BeanServiceImpl3.class)
    private BeanService service4;


    @PostConstruct
    public void init() {
        System.out.println("3333");
        // do some destruction work (like releasing pooled connections)
    }

    public BeanService getBeanService() {
        return service4;
    }
}
