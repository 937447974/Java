package com.mybatis.service.impl;

import com.mybatis.dao.UserMapper;
import com.mybatis.po.User;
import com.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl.java
 * <p>
 * Created by 阳君 on 2017/10/26.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insertUser(User user) {
        this.userMapper.insertUser(user);
    }

    @Transactional
    public void insertUsers(List<User> users) {
        this.userMapper.insertUsers(users);
    }

    public User findUserByCode(String code) {
        return this.userMapper.findUserByCode(code);
    }
}
