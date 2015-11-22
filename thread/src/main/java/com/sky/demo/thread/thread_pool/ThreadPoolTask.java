package com.sky.demo.thread.thread_pool;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadPoolTask implements Runnable {
    // 保存任务所需要的数据
    private Object threadPoolTaskData;
    private static int CONSUMER_TASK_SLEEP_TIME = 2000;

    public ThreadPoolTask(Object threadPoolTaskData) {
        this.threadPoolTaskData = threadPoolTaskData;
    }

    @Override
    public void run() {
        // 处理一个任务，这里的处理方式仅仅是一个打印语句
        System.out.println("======start " + threadPoolTaskData);
        try {
            //便于观察，等待一段时间
            Thread.sleep(CONSUMER_TASK_SLEEP_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=====================finish " + threadPoolTaskData);
        threadPoolTaskData = null;
    }
}
