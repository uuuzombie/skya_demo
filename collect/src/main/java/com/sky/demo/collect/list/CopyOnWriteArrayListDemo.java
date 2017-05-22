package com.sky.demo.collect.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 17/5/22.
 */
public class CopyOnWriteArrayListDemo {


    public static class MyTask1 implements Runnable {

        private List<String> list;

        public MyTask1(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++) {
                list.add(String.valueOf(i));
            }
        }
    }

    public static class MyTask2 implements Runnable {

        private List<String> list;

        public MyTask2(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++) {
                list.add(String.valueOf(i * i));
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

//        List<String> list = new ArrayList<>();            //非线程安全
//        List<String> list = new LinkedList<>();           //非线程安全
        List<String> list = new CopyOnWriteArrayList<>();   //线程安全


        Thread thread1 = new Thread(new MyTask1(list));
        Thread thread2 = new Thread(new MyTask2(list));

        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        System.out.println(list.size());
    }
}
