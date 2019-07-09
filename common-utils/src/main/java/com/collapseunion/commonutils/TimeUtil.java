package com.collapseunion.commonutils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author CloudSen
 */
public class TimeUtil {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 将Date格式化为指定的格式输出
     *
     * @param date    日期
     * @param pattern 指定格式
     * @return 日期字符串
     */
    public static String parseDateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
