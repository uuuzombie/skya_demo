package com.sky.demo.common.proxy.dynamic_proxy;

import com.sky.demo.common.proxy.bean.ISubject;
import com.sky.demo.common.proxy.bean.impl.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyFactory {

    //客户类调用此工厂方法获得代理对象。
    //对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
    public static ISubject getInstance() {
        ISubject delegate = new RealSubject();

        InvocationHandler handler = new DynamicProxy(delegate);

        ISubject proxy = (ISubject) Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                new Class[]{ISubject.class},
                handler
        );
        return proxy;
    }
}
