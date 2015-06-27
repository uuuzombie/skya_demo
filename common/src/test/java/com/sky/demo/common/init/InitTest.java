package com.sky.demo.common.init;

import org.junit.Test;

/**
 * Created by rg on 15/6/27.
 */
public class InitTest {


    @Test
    public void test_Bird() {
        Bird bird = new Bird();
    }

    //父类的（静态变量、静态初始化块）=> 子类的（静态变量、静态初始化块）=>
    //父类的（变量、初始化块、构造器）=> 子类的（变量、初始化块、构造器）。
    @Test
    public void test_Chicken() {
        Chicken chicken = new Chicken();
    }
}
