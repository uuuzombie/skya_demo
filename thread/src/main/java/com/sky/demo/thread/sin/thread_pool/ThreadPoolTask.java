package com.sky.demo.thread.sin.thread_pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadPoolTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTask.class);

    // 保存任务所需要的数据
    private Object threadPoolTaskData;
    private static int CONSUMER_TASK_SLEEP_TIME = 2000;

    public ThreadPoolTask(Object threadPoolTaskData) {
        this.threadPoolTaskData = threadPoolTaskData;
    }

    @Override
    public void run() {
        // 处理一个任务，这里的处理方式仅仅是一个打印语句
        logger.info("======start " + threadPoolTaskData);
        try {
            //便于观察，等待一段时间
            Thread.sleep(CONSUMER_TASK_SLEEP_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("=====================finish " + threadPoolTaskData);
        threadPoolTaskData = null;
    }
}
