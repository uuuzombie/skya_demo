package com.sky.demo.thread.thread_local.static_action;

/**
 * Created by rg on 2015/10/4.
 */
public class StaticAction {

    private static int value = 0;

    public static int getValue() {
        return value;
    }

    public static void setValue(int val) {
        value = val;
    }

    public static void increase() { //实际运行结果显示i值为随机的数字。为了实现互斥访问，需要synchronized
        int temp = getValue();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        temp++;
        value = temp;
    }

    public synchronized static void syncIncrease() {
        int temp = value;

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        temp++;
        setValue(temp);
    }

}
