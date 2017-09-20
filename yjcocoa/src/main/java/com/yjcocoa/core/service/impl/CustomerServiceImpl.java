package com.yjcocoa.core.service.impl;

import com.yjcocoa.common.utils.Page;
import com.yjcocoa.core.dao.CustomerDao;
import com.yjcocoa.core.po.Customer;
import com.yjcocoa.core.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客户管理
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    // 声明DAO属性并注入
    @Autowired
    private CustomerDao customerDao;

    // 客户列表
    public Page<Customer> findCustomerList(Integer page, Integer rows, String name, String source, String industry, String level) {
        // 创建客户对象
        Customer customer = new Customer();
        // 判断客户名称
        if (StringUtils.isNotBlank(name)) {
            customer.setName(name);
        }
        // 判断客户信息来源
        if (StringUtils.isNotBlank(source)) {
            customer.setSource(source);
        }
        // 判断客户所属行业
        if (StringUtils.isNotBlank(industry)) {
            customer.setIndustry(industry);
        }
        // 判断客户级别
        if (StringUtils.isNotBlank(level)) {
            customer.setLevel(level);
        }
        // 当前页
        customer.setStart((page - 1) * rows);
        // 每页数
        customer.setRows(rows);
        // 查询客户列表
        List<Customer> customers =
                customerDao.selectCustomerList(customer);
        // 查询客户列表总记录数
        Integer count = customerDao.selectCustomerListCount(customer);
        // 创建Page返回对象
        Page<Customer> result = new Page<Customer>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    /**
     * 创建客户
     */
    public int createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    /**
     * 通过id查询客户
     */
    public Customer getCustomerById(Integer id) {
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    /**
     * 更新客户
     */
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    /**
     * 删除客户
     */
    public int deleteCustomer(Integer id) {
        return customerDao.deleteCustomer(id);
    }


}
