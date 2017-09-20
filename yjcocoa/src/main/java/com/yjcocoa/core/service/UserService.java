package com.yjcocoa.core.service;

import com.yjcocoa.core.po.User;

/**
 * 用户Service层接口
 */
public interface UserService {

    // 通过账号和密码查询用户
    public User findUser(String code, String password);

}
