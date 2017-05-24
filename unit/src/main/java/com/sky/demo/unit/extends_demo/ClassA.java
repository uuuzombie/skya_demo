package com.sky.demo.unit.extends_demo;

/**
 * Created by user on 17/5/24.
 */
public class ClassA {

    String s;

    public ClassA() {
        System.out.println(1);
    }

    public ClassA(String s) {
        System.out.println(2);
        this.s = s;
    }
}
