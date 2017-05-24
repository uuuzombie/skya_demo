package com.sky.demo.unit.static_param;

/**
 * Created by user on 17/5/24.
 */
public class StaticDemo {

    static StaticDemo staticDemo = new StaticDemo();
    static int a;
    static int b = 0;    //注：会让 第一步中构造函数之后的b重新赋值

    static {
        System.out.println(StaticDemo.a + " " + StaticDemo.b);
    }

    public StaticDemo() {
        a++;
        b++;
    }

    public static void main(String[] args) {
        System.out.println(StaticDemo.a + " " + StaticDemo.b);
    }
}
