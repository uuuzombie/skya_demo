package com.sky.demo.collections.base;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

/**
 * Created by rg on 2015/6/23.
 */
public class IntTest {


    @Test
    public void test_String2Int(){

        String str = "123";

        int b = Integer.parseInt(str);
        System.out.println(b);

        int c = Integer.parseInt(str,10);		//10 为进制
        System.out.println(c);

        int d = Integer.valueOf(str).intValue();
        System.out.println(d);

        str = "123.0";
        int e = NumberUtils.toInt(str);     //注：str如果有小数，则值为0
        System.out.println(e);
    }

    @Test
    public void test_Int2String(){

        int a = 0;
        System.out.println(String.valueOf(a));

        System.out.println(Integer.toString(a));

        System.out.println("" + a);
    }

}
