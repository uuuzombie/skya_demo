package com.sky.demo.thread.java_thread.demo04;

import org.apache.commons.lang.StringUtils;

/**
 * Created by user on 17/1/7.
 */
public class App13 {

    private int num;

    //如果不加synchronized ，则会有线程安全问题
    public synchronized void add(String name) {

        try {
            if (StringUtils.equals(name, "A")) {
                num = 100;
                System.out.println("set A num : " + num);
                Thread.sleep(2000);
            } else if (StringUtils.equals(name, "B")) {
                num = 200;
                System.out.println("set B num : " + num);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
