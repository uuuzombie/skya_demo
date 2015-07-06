package com.sky.demo.tools.sn;

import org.junit.Test;

import java.util.Random;

/**
 * Created by rg on 2015/6/29.
 */
public class KeyGenTest {

    @Test
    public void test_makeKey() {

        String name = "dev_sky";
        Random r = new Random();
        System.out.println(name);
        System.out.println(KeyGen.MakeKey(name, 0, r.nextInt(100000)));
    }
}
