package com.mybatis.po;

import java.io.Serializable;

/**
 * Language.java
 * <p>
 * Created by 阳君 on 2017/10/27.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code; // 编码
    private String name; // 名称

    public Language() {
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

    @Override
    public String toString() {
        return "Language{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
