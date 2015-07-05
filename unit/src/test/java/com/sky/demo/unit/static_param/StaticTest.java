package com.sky.demo.unit.static_param;

import org.junit.Test;

public class StaticTest {

    @Test
    public void test_int_static(){
        IntStatic intStatic = new IntStatic();
        intStatic.test();

        System.out.println(intStatic.test());
    }

    @Test
    public void test_Object_static() {
        ObjectStatic objectStatic = new ObjectStatic();
        System.out.println(objectStatic.test());
    }
}
