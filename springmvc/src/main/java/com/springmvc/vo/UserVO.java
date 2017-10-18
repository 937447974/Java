package com.springmvc.vo;

import com.springmvc.po.User;

import java.util.List;

/**
 * 用户包装类
 */
public class UserVO {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
