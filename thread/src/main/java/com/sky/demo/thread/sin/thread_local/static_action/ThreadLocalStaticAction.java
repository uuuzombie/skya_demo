package com.sky.demo.thread.sin.thread_local.static_action;

/**
 * Created by rg on 2015/10/4.
 */
public class ThreadLocalStaticAction {

    private static ThreadLocal<Integer> threadLocalValue = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static Integer getValue() {
        return threadLocalValue.get();
    }

    public static void setValue(Integer value) {
        threadLocalValue.set(value);
    }

    public static void removeValue() {
        threadLocalValue.remove();
    }


    public static void increase() {
        int temp = getValue();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        temp++;
        setValue(temp);
    }

}
