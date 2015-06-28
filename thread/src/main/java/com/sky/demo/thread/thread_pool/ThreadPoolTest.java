package com.sky.demo.thread.thread_pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadPoolTest {

    // 让可执行程序休息一下
    private static int EXE_TIME = 0;
    private static int PRODUCER_TASK_MAX_NUMBER = 10;

    private static int CORE_POOL_SIZE = 2;
    private static int MAX_POOL_SIZE = 4;
    private static int QUEUE_SIZE = 3;

    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                3, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(QUEUE_SIZE),
                new RejectedExecutionHandler() {  //自定义策略（只打印，不处理）
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("asyn_thread_rejected");
                    }
        });

        //常用四种处理策略
        //1 new ThreadPoolExecutor.AbortPolicy() 处理程序遭到拒绝时将抛出运行时RejectedExecutionException
        //2 new ThreadPoolExecutor.CallerRunsPolicy() 线程调用运行该任务的execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度
        //3 new ThreadPoolExecutor.DiscardPolicy() 不能执行的任务将被删除
        //4 new ThreadPoolExecutor.DiscardOldestPolicy() 如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）

        // 5 自定义处理策略
//        new RejectedExecutionHandler() {  //自定义策略（只打印，不处理）
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                System.out.println("asyn_thread_rejected");
//            }
//        }

        for (int i = 1; i <= PRODUCER_TASK_MAX_NUMBER; i++) {
            try {
                String task = "task@ " + i;
                System.out.println("put " + task);
                threadPool.execute(new ThreadPoolTask(task));

                // 便于观察，等待一段时间
                Thread.sleep(EXE_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        threadPool.shutdown();

    }
}
