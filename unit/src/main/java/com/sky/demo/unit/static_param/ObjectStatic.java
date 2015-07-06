package com.sky.demo.unit.static_param;


import com.sky.demo.unit.web_mock.User;

public class ObjectStatic {

    //private static Object o ;
    //private static String o;

    //private static List<String> o;

    private static User o;      //static 对象默认初始化为null

    public Object test(){
        return o;
    }
}
