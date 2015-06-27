package com.sky.demo.common.proxy.dynamic_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by rg on 2014/7/9.
 * 动态代理类只能代理接口，代理类都需要实现InvocationHandler类，实现invoke方法。
 * 该invoke方法就是调用被代理接口的所有方法时需要调用的，该invoke方法返回的值是被代理接口的一个实现类
 */
public class DynamicProxy implements InvocationHandler {

    // 代理类持有一个委托类的对象引用
    private Object delegate;

    public DynamicProxy(Object delegate) {
        this.delegate = delegate;
    }

    //拦截关联的这个实现类的方法被调用时将被执行
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before calling " + method);

        //利用反射机制将请求分派给委托类处理。Method的invoke返回Object对象作为方法执行结果。
        Object result = method.invoke(delegate,args);
        System.out.println("After calling " + method);

        return result;
    }
}
