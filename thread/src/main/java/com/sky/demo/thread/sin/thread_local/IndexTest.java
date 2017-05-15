package com.sky.demo.thread.sin.thread_local;

/**
 * Created by rg on 9/18/15.
 */
public class IndexTest {

    //private static Index NUM = new Index();

    private static ThreadLocal<Index> local = new ThreadLocal<Index>(){
        @Override
        protected Index initialValue() {
            //return NUM;     //注意这里，返回的是已经定义好的对象num，而不是new Index(),引用的副本和引用指向的是同一个对象
            return new Index();
        }
    };

    static class Index {
        int num;
        public void increase(){
            num++;
        }
    }


    public static void main(String[] args) {
        int count = 5;
        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; ++i) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Index index = local.get();
                    for (int j = 0; j < 1000; ++j) {
                        index.increase();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + index.num);
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }
}
