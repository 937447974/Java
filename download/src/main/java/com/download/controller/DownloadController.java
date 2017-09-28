package com.download.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * DownloadController.java
 * <p>
 * Created by didi on 2017/9/27.
 * Copyright © 2017年 download. All rights reserved.
 */
@Controller
public class DownloadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String fileName) throws Exception {
        // 指定要下载的文件所在路径
        String path = request.getServletContext().getRealPath("/upload/");
        // 创建该文件对象
        File file = new File(path + File.separator + fileName);
        // 对文件名编码，防止中文文件乱码
        fileName = this.getFilename(request, fileName);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", fileName);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

    @RequestMapping("/download1")
    public ResponseEntity<String> downFile(HttpServletResponse response, HttpServletRequest request, String fileName)
            throws Exception {
        String path = request.getServletContext().getRealPath("/upload/");
        // 创建该文件对象
        File file = new File(path + File.separator + fileName);
        long fSize = file.length();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/x-download");
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Length", String.valueOf(fSize));
        response.setHeader("Content-Disposition", "attachment;fileName=" + this.getFilename(request, fileName));
        long pos = 0;
        if (null != request.getHeader("Range")) {
            // 断点续传
            response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
            try {
                pos = Long.parseLong(request.getHeader("Range").replaceAll("bytes=", "").replaceAll("-", ""));
            } catch (NumberFormatException e) {
                pos = 0;
            }
        }
        String contentRange = "bytes " + pos + "-" + (fSize - 1) + "/" + fSize;
        response.setHeader("Content-Range", contentRange);
        InputStream inputStream = null;
        ServletOutputStream out = null;
        try {
            inputStream = new FileInputStream(file);
            inputStream.skip(pos);
            out = response.getOutputStream();
            byte[] buffer = new byte[1024 * 100];
            int length = 0;
            while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, length);
                Thread.sleep(100);
            }
        } finally {
            if (null != out) out.flush();
            if (null != out) out.close();
            if (null != inputStream) inputStream.close();
        }
        return new ResponseEntity(null, HttpStatus.OK);
    }

    /**
     * 根据浏览器的不同进行编码设置，返回编码后的文件名
     */
    String getFilename(HttpServletRequest request, String filename) throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }
}
