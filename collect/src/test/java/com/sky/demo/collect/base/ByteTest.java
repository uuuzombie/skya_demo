package com.sky.demo.collect.base;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by rg on 15/6/27.
 */
public class ByteTest {

    @Test
    public void test_Byte_length(){

        byte[] raw = new byte[10];

        Vector vector1 = new Vector();
        vector1.addElement(raw);
        System.out.println("Memcahe-------value length:" + raw.length + ",size:" +  raw.length * Byte.SIZE);
        System.out.println("Memcahe-------compress size:" + vector1.size());

    }
}
