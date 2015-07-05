package com.sky.demo.unit.logic;

/**
 * Created by rg on 15/7/5.
 */
public class Logic {

    public static void fun(boolean a,boolean b){
        if (!a && !b){
            System.out.println("!a && !b access");
        }

        if (!a || !b) {
            System.out.println("!a || !b  access");
        }
    }

}
