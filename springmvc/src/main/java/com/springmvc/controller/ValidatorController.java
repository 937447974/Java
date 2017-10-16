package com.springmvc.controller;

import com.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * ValidatorController.java
 * <p>
 * Created by didi on 2017/10/16.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Controller
@RequestMapping("/validator")
public class ValidatorController {

    @RequestMapping("")
    public String index() {
        return "validator/index";
    }

    @RequestMapping("/login")
    public String login(Model model, @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                FieldError fieldError = (FieldError) objectError;
                model.addAttribute(fieldError.getField() + "Valid", objectError.getDefaultMessage());
            }
            return "validator/index";
        }
        model.addAttribute("msg", user.toString());
        return "validator/success";
    }

}
