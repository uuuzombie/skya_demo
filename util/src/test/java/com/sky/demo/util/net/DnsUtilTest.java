package com.sky.demo.util.net;

import org.junit.Test;

/**
 * Created by rg on 2016/2/17.
 */
public class DnsUtilTest {

    @Test
    public void test_getLocalHost() {
        System.out.println(DnsUtil.getLocalHost());
    }

    @Test
    public void test_getHostAddress() {
        System.out.println(DnsUtil.getHostAddress());
    }

    @Test
    public void test_getHostName() {
        System.out.println(DnsUtil.getHostName());
    }

    @Test
    public void test_getRawAddress() {
        for (byte b : DnsUtil.getRawAddress()) {
            System.out.println(b);
        }
    }
}
