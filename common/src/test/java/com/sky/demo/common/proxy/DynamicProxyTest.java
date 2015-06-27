package com.sky.demo.common.proxy;


import com.sky.demo.common.proxy.bean.ISubject;
import com.sky.demo.common.proxy.dynamic_proxy.DynamicProxyFactory;
import org.junit.Test;

public class DynamicProxyTest {

    @Test
    public void test_DynamicProxyFactory(){
        ISubject subject = DynamicProxyFactory.getInstance();

        subject.print("Hello World");
    }
}
