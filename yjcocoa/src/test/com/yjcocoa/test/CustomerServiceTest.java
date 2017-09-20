package com.yjcocoa.test;

import com.yjcocoa.common.utils.Page;
import com.yjcocoa.core.po.Customer;
import com.yjcocoa.core.service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * CustomerServiceTest.java
 * <p>
 * Created by didi on 2017/9/20.
 * Copyright © 2017年 yjcocoa. All rights reserved.
 */
public class CustomerServiceTest {

    private CustomerService customerService() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = act.getBean(CustomerService.class);
        return customerService;
    }


    @Test
    public void findCustomerListTesl() {
        Page<Customer> page = this.customerService().findCustomerList(1,1,"Y",null,null,null);
        System.out.println(page.getRows());
    }

    @Test
    public void createCustomerTest() {
        Customer customer = new Customer();
        customer.setPhone("937lafj");
        customer.setName("YJ1");
        this.customerService().createCustomer(customer);
    }



//
//    // 通过id查询客户
//    public Customer getCustomerById(Integer id);
//
//    // 更新客户
//    public int updateCustomer(Customer customer);
//
//    // 删除客户
//    public int deleteCustomer(Integer id);
}
