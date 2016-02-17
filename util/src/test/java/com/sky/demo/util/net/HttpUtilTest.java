package com.sky.demo.util.net;

import org.junit.Test;

/**
 * Created by rg on 2015/7/21.
 */
public class HttpUtilTest {

    @Test
    public void test_getUserIpAddress() {

    }

    @Test
    public void test_getServerIp() {
        String ip = HttpUtil.getServerIpAddress();
        System.out.println(ip);
    }

    @Test
    public void test_getLocalIp() {
        String ip = HttpUtil.getLocalIp();
        System.out.println(ip);
    }

}
