package com.yjcocoa.core.test;

import com.yjcocoa.core.mapper.CustomerMapper;
import com.yjcocoa.core.po.Customer;
import com.yjcocoa.core.service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringMyBatisTest.java
 * <p>
 * Created by didi on 2017/9/18.
 * Copyright © 2017年 YJCocoa. All rights reserved.
 */
public class SpringMyBatisTest {

    @Test
    public void test() {
        String xmlPath = "applicationContext.xml";
        ApplicationContext act = new ClassPathXmlApplicationContext(xmlPath);
        CustomerMapper customerMapper = act.getBean(CustomerMapper.class);
        Customer customer = customerMapper.findCustomerById(1);
        System.out.println(customer.toString());
    }

    @Test
    public void transactionalTest() {
        String xmlPath = "applicationContext.xml";
        ApplicationContext act = new ClassPathXmlApplicationContext(xmlPath);
        CustomerService customerService = act.getBean(CustomerService.class);
        Customer customer = new Customer();
        customer.setJobs("2");
        customer.setPhone("937lafj");
        customer.setUsername("YJ1");
        customerService.addCustomer(customer);
    }
}
