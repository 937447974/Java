package com.mybatis.po;

import java.io.Serializable;
import java.util.List;

/**
 * User.java
 * <p>
 * Created by 阳君 on 2017/10/26.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;  // 用户id
    private String code; // 用户账号
    private String name; // 用户昵称
    private Language language; // 工作开发语言
    private List<Language> languages;// 掌握的语言

    public User() {
    }

    public User(String code) {
        this.code = code;
    }

    public User(String code, String name) {
        this.code = code;
        this.name = name;
    }

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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", language=" + language +
                ", languages=" + languages +
                '}';
    }
}
