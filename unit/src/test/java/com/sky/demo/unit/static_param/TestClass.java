package com.sky.demo.unit.static_param;

/**
 * Created by rg on 8/23/15.
 */
public class TestClass {

    private static void testMethod() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ((TestClass)null).testMethod();
    }
}
