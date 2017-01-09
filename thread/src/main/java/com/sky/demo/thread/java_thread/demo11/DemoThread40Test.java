package com.sky.demo.thread.java_thread.demo11;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread40Test {

    //1、一个Lock里面可以创建多个Condition实例，实现多路通知
    //2、notify()方法进行通知时，被通知的线程时Java虚拟机随机选择的，但是ReentrantLock结合Condition可以实现有选择性地通知
    //Condition的await()方法是释放锁的
    public static void main(String[] args) {

        try {
            App40 app = new App40();

            DemoThread40 demoThread40 = new DemoThread40(app);
            demoThread40.start();

            Thread.sleep(4000);
            app.conditionSignal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
