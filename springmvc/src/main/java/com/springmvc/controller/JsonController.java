package com.springmvc.controller;

import com.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * JsonController.java
 * <p>
 * Created by 阳君 on 2017/10/17.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Controller
@RequestScope
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("")
    public String index() {
        return "json/index";
    }

    /**
     * 接收页面请求的JSON数据，并返回JSON格式结果
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(@RequestBody User user) {
        // 打印接收的JSON格式数据
        System.out.println(user);
        // 返回JSON格式的响应
        return user;
    }

    /**
     * 接收RESTful风格的请求,其接收方式为GET
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User selectUser(@PathVariable("id") String id) {
        //查看数据接收
        System.out.println("id=" + id);
        User user = new User();
        //模拟根据id查询出到用户对象数据
        if (id.equals("1234")) {
            user.setUsername("tom");
        }
        //返回JSON格式的数据
        return user;
    }

}
