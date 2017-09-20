package com.yjcocoa.core.po;

import java.io.Serializable;

/**
 * 用户持久化类
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;      //用户id
    private String code;     //用户账号
    private String name;     //用户名称
    private String password; //用户密码
    private Integer state;   //用户状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
