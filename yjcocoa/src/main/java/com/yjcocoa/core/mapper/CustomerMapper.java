package com.yjcocoa.core.mapper;

import com.yjcocoa.core.po.Customer;

/**
 * CustomerMapper.java
 * <p>
 * Created by didi on 2017/9/15.
 * Copyright © 2017年 YJCocoa. All rights reserved.
 */
public interface CustomerMapper {
    public Customer findCustomerById(Integer id);
    public void addCustomer(Customer customer);
}
