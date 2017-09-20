package com.yjcocoa.core.service;

import com.yjcocoa.common.utils.Page;
import com.yjcocoa.core.po.Customer;

public interface CustomerService {
    
    // 查询客户列表
    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String name, String source,
                                           String industry, String level);

    public int createCustomer(Customer customer);

    // 通过id查询客户
    public Customer getCustomerById(Integer id);

    // 更新客户
    public int updateCustomer(Customer customer);

    // 删除客户
    public int deleteCustomer(Integer id);

}
