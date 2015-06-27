package com.sky.demo.common.proxy.static_proxy;


import com.sky.demo.common.proxy.bean.ISubject;
import com.sky.demo.common.proxy.bean.impl.RealSubject;

public class StaticProxyFactory {

    //客户类调用此工厂方法获得代理对象。
    //对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
    public static ISubject getInstance(){
        return new StaticProxy(new RealSubject());
    }
}
