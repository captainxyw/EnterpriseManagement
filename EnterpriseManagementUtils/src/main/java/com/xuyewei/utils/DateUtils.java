package com.xuyewei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:DateUtils
 * Package:com.xuyewei.utils
 * Description:
 *
 * @Date:2019/11/23 18:47
 * @Author:xuyewei
 */

public class DateUtils {
    //日期转换成字符串
    public static String date2String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String format = sdf.format(date);
        return format;
    }
    //字符串转换成日期
    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.parse(str);
    }
}
