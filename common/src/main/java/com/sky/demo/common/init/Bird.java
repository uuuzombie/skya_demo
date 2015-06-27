package com.sky.demo.common.init;

/**
 * Created by rg on 15/6/27.
 */
public class Bird {

    public Bird() {
        System.out.println("Constructor bird");
    }

    //初始化块
    {
        System.out.println("Field Bird");
    }

    //静态初始化块
    static {
        System.out.println("Static Field Bird");
    }
}
