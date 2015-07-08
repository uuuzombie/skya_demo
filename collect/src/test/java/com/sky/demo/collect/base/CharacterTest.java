package com.sky.demo.collect.base;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rg on 2015/6/23.
 */
public class CharacterTest {

    @Test
    public void test_Character(){

        Character ca = new Character('a');
        Character cb = new Character('a');

        assertTrue(ca.compareTo(cb) == 0);

        assertTrue(ca.equals(cb));

        assertTrue(ca != cb);   //注意ca != cb ,比较的是地址
    }
}
