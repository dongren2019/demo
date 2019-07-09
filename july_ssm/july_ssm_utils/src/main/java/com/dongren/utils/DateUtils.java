package com.dongren.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dongren
 * @create 2019-06-30 16:25
 */
public class DateUtils {

    //日期转换车工字符串
    public static String date2String(Date date,String pattern){
        DateFormat format = new SimpleDateFormat(pattern);
        String s = format.format(date);
        return s;
    }

    //日期转换车工字符串
    public static Date string2Date(String date,String pattern) throws ParseException {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.parse(date);
    }
}
