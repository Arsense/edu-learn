package edu.cl.learn.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 时间转换工具类
 * @Author: Clay
 * @Date: 2021/2/12 2:15 下午
 */
public class DateTimeUtil {

    public static final String STANDER_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static String dateFormat(Date date) {
        if (null == date) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(STANDER_FORMAT);
        return dateFormat.format(date);
    }
}
