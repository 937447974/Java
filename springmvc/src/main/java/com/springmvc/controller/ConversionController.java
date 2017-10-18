package com.springmvc.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * ConversionController.java
 * <p>
 * Created by 阳君 on 2017/10/18.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Controller
@RequestMapping("/conversion")
public class ConversionController  {

    @RequestMapping("")
    public String index() {
        return "conversion/index";
    }

    @RequestMapping("/customDate")
    public String customDate(Model model, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        model.addAttribute("msg", date.toString());
        return "success";
    }

}
