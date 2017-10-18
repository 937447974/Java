package com.springmvc.conversion;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 使用Formatter自定义日期转换器
 */
public class DateFormatter implements Formatter<Date> {

    // 定义日期格式
    String datePattern = "yyyy-MM-dd HH:mm:ss";

    public String print(Date date, Locale locale) {
        return new SimpleDateFormat().format(date);
    }

    public Date parse(String source, Locale locale) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        return simpleDateFormat.parse(source);
    }
}
