package com.sky.demo.util;


import com.google.common.collect.Lists;
import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

import java.util.List;

public class NumberUtilsTest {

    @Test
    public void test_NumberUtils_toInt(){

        int a = NumberUtils.toInt("1234");
        System.out.println(a);

        int b = NumberUtils.toInt("1234.0");    //带小数点会转化为0！！ 因为源码会吞异常
        System.out.println(b);

        int c = Integer.valueOf("1234.0");      //抛异常
        System.out.println(c);
    }


    @Test
    public void test_NumberUtils_toFloat(){

        float a = NumberUtils.toFloat("1234");
        System.out.println(a);

        float b = NumberUtils.toFloat("1234.0");
        System.out.println(b);

        int c = (int)b;
        System.out.println(c);


        int oldTax1 = (int) NumberUtils.toDouble("123.0");
        System.out.println(oldTax1);

        int oldTax2 = (int) NumberUtils.toDouble("-123.0");
        System.out.println(oldTax2);

        int oldTax3 = (int) NumberUtils.toDouble("123");
        System.out.println(oldTax3);

        int oldTax4 = (int) NumberUtils.toDouble("-123");
        System.out.println(oldTax4);
    }

    @Test
    public void test_NumberUtils_isDigits() {
        List<String> list = Lists.newArrayList("-1", "0", "1", "-0.5", "1.0", "2.1");
        for (String str : list) {
            if (!NumberUtils.isDigits(str)) {
                System.out.println(str + " is not digit");
            }
        }
    }

    @Test
    public void test_NumberUtils_isNumber() {
        List<String> list = Lists.newArrayList("-1", "0", "1", "1.0", "2.1");
        for (String str : list) {
            if (!NumberUtils.isNumber(str)) {
                System.out.println(str + " is not number");
            }
        }
    }
}
