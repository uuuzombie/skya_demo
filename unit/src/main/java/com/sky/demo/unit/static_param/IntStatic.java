package com.sky.demo.unit.static_param;


public class IntStatic {

    private static int i;           //int static未初始化，则默认为0

    public int test(){
        i++;
        return i;
    }
}
