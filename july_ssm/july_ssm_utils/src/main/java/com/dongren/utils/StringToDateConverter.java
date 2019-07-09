package com.dongren.utils;

/**
 * @author dongren
 * @create 2019-06-30 21:28
 */

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换成日期的转换器
 *
 * @author dongren
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * 进行类型转换的方法
     */
    public Date convert(String source) {
// 判断
        if (source == null) {
            throw new RuntimeException("参数不能为空");
        }
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
// 解析字符串
            Date date = df.parse(source);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("类型转换错误");
        }
    }
}
