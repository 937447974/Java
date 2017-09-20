package com.yjcocoa.test;

import com.yjcocoa.core.po.BaseDict;
import com.yjcocoa.core.service.BaseDictService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * BaseDictServiceTest.java
 * <p>
 * Created by didi on 2017/9/20.
 * Copyright © 2017年 yjcocoa. All rights reserved.
 */
public class BaseDictServiceTest {

    private BaseDictService baseDictService() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        BaseDictService baseDictService = act.getBean(BaseDictService.class);
        return baseDictService;
    }

    @Test
    public void findUserTest() {
        List<BaseDict> list = this.baseDictService().findBaseDictByTypeCode("001");
        System.out.println(list);
    }
}
