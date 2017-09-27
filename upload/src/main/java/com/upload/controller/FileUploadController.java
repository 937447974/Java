package com.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * FileUploadController.java
 * <p>
 * Created by didi on 2017/9/26.
 * Copyright © 2017年 upload. All rights reserved.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileUpload")
    public String handleFormUpload(@RequestParam("uploadfile") List<MultipartFile> uploadfile, HttpServletRequest request) {
        // http://www.plupload.com
        if (!uploadfile.isEmpty()) {
            for (MultipartFile file : uploadfile) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                String dirPath = request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                String filePathName = dirPath + originalFilename;
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(filePathName));
                    System.out.println(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            return "success";
        } else {
            return "error";
        }
    }

}
