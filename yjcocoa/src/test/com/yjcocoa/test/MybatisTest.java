package com.yjcocoa.test;

import com.yjcocoa.mapper.CustomerMapper;
import com.yjcocoa.po.Customer;
import com.yjcocoa.service.CustomerService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

/**
 * MybatisTest.java
 * <p>
 * Created by didi on 2017/9/14.
 * Copyright © 2017年 YJCocoa. All rights reserved.
 */
public class MybatisTest {

    @Test
    public void myBatisTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = sqlSession.selectOne("com.yjcocoa.mapper"
                                                 +".CustomerMapper.findCustomerById", 1);
        System.out.println(customer.toString());
        customer = sqlSession.selectOne("com.yjcocoa.mapper"
                                        +".CustomerMapper.findCustomerById1", 1);
        System.out.println(customer.toString());
        sqlSession.close();
    }

}
