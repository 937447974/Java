package com.mybatis.service;

import com.github.pagehelper.Page;
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

    void deleteUser(String code);

    void deleteUsers(List<String> codes);

    void updateUser(User user);

    void updateUsers(List<User> users);

    User selectUser(User user);
    User selectUserAndLanguage(User user);

    Page<User> selectUsers(User user, int pageNum, int pageSize);

}
