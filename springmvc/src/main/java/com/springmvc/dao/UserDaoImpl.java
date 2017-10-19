package com.springmvc.dao;

import com.springmvc.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * UserDaoImpl.java
 * <p>
 * Created by 阳君 on 2017/10/18.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Repository
public class UserDaoImpl implements UserDao {
    public void addUser() {
        System.out.println("addUser");
    }
}
