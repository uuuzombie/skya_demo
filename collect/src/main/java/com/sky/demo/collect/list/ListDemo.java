package com.sky.demo.collect.list;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by user on 17/5/17.
 * CopyOnWriteArrayList
 * 缺点，就是修改代价十分昂贵，每次修改都伴随着一次的数组复制；
 * 优点，就是在并发下不会产生任何的线程安全问题，也就是绝对的线程安全
 *
 * 随着CopyOnWriteArrayList中元素的增加，CopyOnWriteArrayList的修改代价将越来越昂贵
 * CopyOnWriteArrayList适用于读操作远多于修改操作的并发场景中。
 */
public class ListDemo {


    public static class MyThread1 extends Thread {

        private List<Integer> list;

        public MyThread1(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {

            for (Integer integer : list) {
//                try {
//                    Thread.sleep(50);
//                    System.out.println(integer);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(integer);

            }

        }
    }

    public static class MyThread2 extends Thread {

        private List<Integer> list;

        public MyThread2(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
            }
        }
    }


    public static void main(String[] args) {

//        List<Integer> list = Lists.newArrayList();  //java.util.ConcurrentModificationException
//        List<Integer> list = Lists.newLinkedList();  //java.util.ConcurrentModificationException
        List<Integer> list = Lists.newCopyOnWriteArrayList();  //No Exception


        for (Integer i = 0; i < 1000; i++) {
            list.add(i);
        }

        MyThread1 myThread1 = new MyThread1(list);
        MyThread2 myThread2 = new MyThread2(list);

        myThread1.start();
        myThread2.start();
    }

}
