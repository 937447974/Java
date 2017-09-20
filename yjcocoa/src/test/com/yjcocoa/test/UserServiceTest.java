package com.yjcocoa.test;

import com.yjcocoa.core.po.User;
import com.yjcocoa.core.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserServiceTest.java
 * <p>
 * Created by didi on 2017/9/20.
 * Copyright © 2017年 yjcocoa. All rights reserved.
 */
public class UserServiceTest {

    private UserService userService() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService customerService = act.getBean(UserService.class);
        return customerService;
    }

    @Test
    public void findUserTest() {
        User user = this.userService().findUser("admin","admin");
    }

}
