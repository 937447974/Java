package com.yjcocoa.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DataConverter.java
 * <p>
 * Created by didi on 2017/9/19.
 * Copyright © 2017年 yjcocoa. All rights reserved.
 */
public class DataConverter implements Converter<String, Date> {

    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效数据格式");
        }
    }

}
