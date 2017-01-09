package com.sky.demo.thread.java_thread.demo06;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread29Test {

    //原子类无法保证线程安全
    public static void main(String[] args) {
        App29 app = new App29();

        List<DemoThread29> thread29List = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            thread29List.add(new DemoThread29(app));
        }

        thread29List.forEach(thread -> thread.start());

        try {
            Thread.sleep(2000);
            System.out.println(App29.atomicInteger.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
