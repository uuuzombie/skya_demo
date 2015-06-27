package com.sky.demo.common.proxy.static_proxy;


import com.sky.demo.common.proxy.bean.ISubject;

import java.util.Date;

public class StaticProxy implements ISubject {

    //代理类持有一个委托类的对象引用
    public ISubject delegate;

    public StaticProxy(ISubject delegate) {
        this.delegate = delegate;
    }

    //将请求分派给委托类执行
    @Override
    public void print(String str) {
        System.out.println("Before calling print()");

        //相当于回调  将请求分派给委托类处理
        delegate.print(str);

        System.out.println("After calling print()");
    }

    @Override
    public Date getDate() {
        System.out.println("Before calling getDate()");
        Date date = delegate.getDate();
        System.out.println("After Calling getDate()");

        return date;
    }
}
