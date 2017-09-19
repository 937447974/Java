package com.yjcocoa.core.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FirstController.java
 * <p>
 * Created by didi on 2017/9/15.
 * Copyright © 2017年 YJCocoa. All rights reserved.
 */
@Controller
@RequestMapping(value = "/hello")
public class FirstController {

    @RequestMapping(value = "/firstController")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        System.out.println("dafasfas");
        model.addAttribute("msg", "Spring MVC gogo");
        return "first";
    }

}
