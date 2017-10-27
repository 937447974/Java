package com.mybatis.dao;

import com.mybatis.po.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserMapper.java
 * <p>
 * Created by 阳君 on 2017/10/26.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
public interface UserMapper {

    @Transactional(propagation = Propagation.MANDATORY)
    void insertUser(User user);
    @Transactional(propagation = Propagation.MANDATORY)
    void insertUsers(List<User> users);

    @Transactional(propagation = Propagation.MANDATORY)
    void deleteUser(String code);
    @Transactional(propagation = Propagation.MANDATORY)
    void deleteUsers(List<String> codes);

    @Transactional(propagation = Propagation.MANDATORY)
    void updateUser(User user);
    @Transactional(propagation = Propagation.MANDATORY)
    void updateUsers(List<User> users);

    List<User> selectUsers(User user);

}
