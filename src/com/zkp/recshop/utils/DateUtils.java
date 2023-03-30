package com.zkp.recshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 将数据库的sql日期格式转换成util日期格式
 * 或者在数据库中将日期设置成timestamp格式，这样就不用格式转换了
 */
public class DateUtils {
    // 对代码进行优化，将共同的语句提取出来写成私有静态变量
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // 将字符串转化为java.util.Date()
    public static java.util.Date strToUtil(String str) {
        try {
            return SIMPLE_DATE_FORMAT.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 将java.util.Date()转化为java.sql.Date()
    public static java.sql.Date utilToSql(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    // 将java.util.Date转化为字符串形式
    public static String utilToString(java.util.Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
