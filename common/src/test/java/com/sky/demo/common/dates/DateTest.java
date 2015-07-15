package com.sky.demo.common.dates;

import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Test;

import java.util.Date;

/**
 * Created by rg on 2015/7/7.
 */
public class DateTest {

    @Test
    public void test_Date_toLocalString(){

        Date now = new Date(System.currentTimeMillis());
        String str = now.toLocaleString();
        System.out.println(str);

        String str2 = DateFormatUtils.format(now ,"yyyy-MM-dd HH:mm:ss");
        System.out.println(str2);
    }

}
