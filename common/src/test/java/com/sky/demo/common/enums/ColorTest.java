package com.sky.demo.common.enums;

import org.junit.Test;

/**
 * Created by rg on 15/6/27.
 */
public class ColorTest {

    @Test
    public void test_getColorByCode() {
        int code = 1;
        Color color = Color.getColorByCode(code);
        System.out.println(color);
    }

    @Test
    public void test_getColorByName() {
        String name = "绿色";
        Color color = Color.getColorByName(name);
        System.out.println(color);
    }
}
