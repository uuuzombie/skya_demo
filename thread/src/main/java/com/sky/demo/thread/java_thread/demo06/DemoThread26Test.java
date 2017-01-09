package com.sky.demo.thread.java_thread.demo06;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread26Test {

    //被volatile修饰的变量，保证了每次读取到的都是最新的那个值。
    //synchronized除了保障了原子性外，其实也保障了可见性。
    //volatile 只保障了可见性，不保证有序性。
    public static void main(String[] args) {
        try {
            DemoThread26 demoThread26 = new DemoThread26();
            demoThread26.start();

            Thread.sleep(2000);
            demoThread26.setRunning(false);
            System.out.println("set the running false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
