package com.sky.demo.unit.extends_demo;

/**
 * Created by user on 17/5/24.
 */
public class ClassB extends ClassA {

    ClassB b;

    public ClassB() {
        System.out.println(3);
    }

    public ClassB(String s) {
        System.out.println(4);
        this.s = s;
        b = new ClassB();
    }


    public static void main(String[] args) {
        ClassB classB = new ClassB("XX");   //注：会调用父类的无参构造函数！
    }

}
