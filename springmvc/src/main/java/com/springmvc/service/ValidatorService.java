package com.springmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * ValidatorService.java
 * <p>
 * Created by 阳君 on 2017/10/16.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Validated
@Service
public class ValidatorService {

    public String checkUser(@NotEmpty(message = "用户名不能为空") String username,
                            @NotEmpty(message = "密码不能为空") @Size(min = 6, max = 9, message = "密码长度应在{min}-{max}个字符")
                                    String password) throws ConstraintViolationException {
        return "User [username=" + username + ", password=" + password + "]";
    }
}
