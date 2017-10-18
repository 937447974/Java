package com.springmvc.controller;

import com.springmvc.po.User;
import com.springmvc.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DataBinderController.java
 * <p>
 * Created by 阳君 on 2017/10/17.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
@Controller
@RequestMapping("/databinder")
public class DataBinderController {

    @RequestMapping("")
    public String index() {
        return "databinder/index";
    }

    @RequestMapping("/editUsers")
    public String editUsers(Model model, UserVO userVO) {
        String msg = "";
        // 循环输出所有用户信息
        for (User user : userVO.getUsers()) {
            // 如果接收的用户id不为空，则表示对该用户进行了修改
            if (user.getId() != null) {
                msg = msg + "修改了id为" + user.getId() + "的用户名为：" + user.getUsername() + "; ";
            }
        }
        model.addAttribute("msg", msg);
        return "success";
    }

}
