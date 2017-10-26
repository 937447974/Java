package com.mybatis.service;

import com.mybatis.po.User;

import java.util.List;

/**
 * UserService.java
 * <p>
 * Created by 阳君 on 2017/10/26.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
public interface UserService {

    void insertUser(User user);

    void insertUsers(List<User> users);

    User findUserByCode(String code);

}
