package com.sky.demo.unit.logic;

import org.junit.Test;

/**
 * Created by rg on 15/7/5.
 */
public class LogicTest {
    @Test
    public void test_Logic1(){

        boolean a = true;
        boolean b = true;

        Logic.fun(a,b);
    }

    @Test
    public void test_Logic2(){

        boolean a = true;
        boolean b = false;

        Logic.fun(a,b);

    }

    @Test
    public void test_Logic3(){

        boolean a = false;
        boolean b = true;

        Logic.fun(a,b);
    }

    @Test
    public void test_Logic4(){

        boolean a = false;
        boolean b = false;

        Logic.fun(a,b);
    }

    @Test
    public void test_if() {

        int a = 2;
        int b = 1;

        int c = 0;
        if (a == 1 || b == 1) {
            c = 1;
        } else if (a == 2 || b == 2){
            c = 2;
        } else {
            c = 3;
        }
        System.out.println(c);
    }
}
