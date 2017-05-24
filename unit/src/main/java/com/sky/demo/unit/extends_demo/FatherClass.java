package com.sky.demo.unit.extends_demo;

/**
 * Created by user on 17/5/24.
 */
public class FatherClass {

    String s;

    public FatherClass() {
        System.out.println(1);
    }

    public FatherClass(String s) {
        System.out.println(2);
        this.s = s;
    }
}
