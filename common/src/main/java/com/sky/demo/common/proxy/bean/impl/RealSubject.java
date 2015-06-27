package com.sky.demo.common.proxy.bean.impl;

import com.sky.demo.common.proxy.bean.ISubject;

import java.util.Date;

/**
 * Created by rg on 15/6/27.
 */
public class RealSubject implements ISubject {
    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public Date getDate() {
        return new Date();
    }
}
