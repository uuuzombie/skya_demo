package com.sky.demo.thread.java_thread.demo11;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread38Test {

    //ReentrantLock持有的是"对象监视器"
    //ReentrantLock和synchronized持有的对象监视器不同
    public static void main(String[] args) {
        App38 app = new App38();

        DemoThread38 demoThread38_01 = new DemoThread38(app);
        DemoThread38 demoThread38_02 = new DemoThread38(app);
        DemoThread38 demoThread38_03 = new DemoThread38(app);
        demoThread38_01.start();
        demoThread38_02.start();
        demoThread38_03.start();

    }
}
