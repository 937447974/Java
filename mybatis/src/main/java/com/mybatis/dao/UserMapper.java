package com.mybatis.dao;

import com.mybatis.po.User;

import java.util.List;

/**
 * UserMapper.java
 * <p>
 * Created by 阳君 on 2017/10/26.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
public interface UserMapper {

    void insertUser(User user);

    void insertUsers(List<User> users);

    void delleteUser(User user);

    User findUserByCode(String code);

}
