package com.sky.demo.common.proxy;


import com.sky.demo.common.proxy.bean.ISubject;
import com.sky.demo.common.proxy.static_proxy.StaticProxyFactory;
import org.junit.Test;

public class StaticProxyTest {

    @Test
    public void test_StaticProxyFactory(){

        ISubject proxy = StaticProxyFactory.getInstance();
        proxy.print("Hello World");
    }
}
