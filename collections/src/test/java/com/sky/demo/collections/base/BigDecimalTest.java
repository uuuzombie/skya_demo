package com.sky.demo.collections.base;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by rg on 15/7/5.
 */
public class BigDecimalTest {

    @Test
    public void test_Decimal() {
        BigDecimal d1 = new BigDecimal("2.0");
        BigDecimal d2 = new BigDecimal("1.1");

        BigDecimal result;
        //result = d1.divide(d2);                  //报错
        result = d1.divide(d2,16, BigDecimal.ROUND_CEILING);
        System.out.println(result);
    }


    @Test
    public void test_Decimal2() {
        BigDecimal d1 = new BigDecimal("2.0");
        BigDecimal d2 = new BigDecimal("1.0");
        BigDecimal result = d1.divide(d2);
        System.out.println(result);
    }
}
