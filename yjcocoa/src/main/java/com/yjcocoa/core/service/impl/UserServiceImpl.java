package com.yjcocoa.core.service.impl;

import com.yjcocoa.core.dao.UserDao;
import com.yjcocoa.core.po.User;
import com.yjcocoa.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    // 注入UserDao
    @Autowired
    private UserDao userDao;

    // 通过账号和密码查询用户
    public User findUser(String code, String password) {
        User user = this.userDao.findUser(code, password);
        return user;
    }

}
