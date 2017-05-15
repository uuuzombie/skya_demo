package com.sky.demo.thread.sin.thread_local.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rg on 2015/9/19.
 */
public class ThreadLocalDateUtil {

    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();


    public static SimpleDateFormat getDateFormat() {
        SimpleDateFormat sf = threadLocal.get();
        if (sf == null) {
            sf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
            threadLocal.set(sf);
        }
        return sf;
    }


    public static String formatDate(Date date) {
        return getDateFormat().format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return getDateFormat().parse(strDate);
    }

}
