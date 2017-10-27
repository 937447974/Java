package com.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.dao.UserMapper;
import com.mybatis.po.User;
import com.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Transactional
    public void deleteUser(String code) {
        if (!StringUtils.isEmpty(code)) {
            this.userMapper.deleteUser(code);
        }
    }

    @Transactional
    public void deleteUsers(List<String> codes) {
        if (codes.size() >= 1) {
            this.userMapper.deleteUsers(codes);
        }
    }

    public void updateUser(User user) {
        if (!StringUtils.isEmpty(user.getCode())) {
            this.userMapper.updateUser(user);
        }
    }

    public void updateUsers(List<User> users) {
        if (users.size() >= 1) {
            this.userMapper.updateUsers(users);
        }
    }

    public User selectUser(User user) {
        List<User> list = this.userMapper.selectUsers(user);
        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }

    public Page<User> selectUsers(User user, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userMapper.selectUsers(user));
    }

}
