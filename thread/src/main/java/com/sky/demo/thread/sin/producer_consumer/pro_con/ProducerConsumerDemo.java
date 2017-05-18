package com.sky.demo.thread.sin.producer_consumer.pro_con;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by user on 17/5/18.
 */
public class ProducerConsumerDemo {

    private static final int MAX_SIZE = 10;


    public static class Producer implements Runnable {

        private List<Task> taskList;
        private Object lock;

        public Producer(List<Task> taskList, Object lock) {
            this.taskList = taskList;
            this.lock = lock;
        }

        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    while (taskList.size() >= MAX_SIZE ) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Task task = new Task();
                    taskList.add(task);

                    lock.notifyAll();

                    System.out.println("Producer [" + Thread.currentThread().getName() + "] put " + task);

                }
            }
        }
    }

    public static class Consumer implements Runnable {

        private List<Task> taskList;
        private Object lock;

        public Consumer(List<Task> taskList, Object lock) {
            this.taskList = taskList;
            this.lock = lock;
        }

        @Override
        public void run() {

            while (true) {
                synchronized (lock) {

                    while (taskList.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Task task = taskList.remove(0);
                    lock.notifyAll();

                    System.out.println("Consumer [" + Thread.currentThread().getName() + "] get " + task);
                }
            }

        }
    }


    public static void main(String[] args) {

        List<Task> tasks = Lists.newArrayList();
        Object lock = new Object();

        for (int i = 0;i < 2; i++) {
            Thread producer = new Thread(new Producer(tasks, lock));
            producer.start();
        }


        for (int i = 0; i < 2; i++) {
            Thread consumer = new Thread(new Consumer(tasks, lock));
            consumer.start();
        }


    }

}
