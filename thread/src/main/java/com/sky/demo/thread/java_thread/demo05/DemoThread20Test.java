package com.sky.demo.thread.java_thread.demo05;

/**
 * Created by user on 17/1/9.
 */
public class DemoThread20Test {

    //Java还支持对"任意对象"作为对象监视器来实现同步的功能。使用格式为synchronized(非this对象)
    //多个线程持有"对象监视器"为同一个对象的前提下，同一时间只能有一个线程可以执行synchronized(非this对象x)代码块中的代码
    public static void main(String[] args) {
        App20 app = new App20();

        DemoThread20_1 demoThread20_1 = new DemoThread20_1(app);
        DemoThread20_2 demoThread20_2 = new DemoThread20_2(app);
        demoThread20_1.start();
        demoThread20_2.start();
    }

}
