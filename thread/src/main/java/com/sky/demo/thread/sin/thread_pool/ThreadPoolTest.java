package com.sky.demo.thread.sin.thread_pool;

/**
 * Created by rg on 15/6/28.
 */
public class ThreadPoolTest {

    // 让可执行程序休息一下
    private static int EXE_TIME = 0;
    private static int PRODUCER_TASK_MAX_NUMBER = 100;

    public static void main(String[] args) {

        for (int i = 1; i <= PRODUCER_TASK_MAX_NUMBER; i++) {
            try {
                String task = "task@ " + i;
                System.out.println("put " + task);
                AsyncExecutor.execute(new ThreadPoolTask(task));

                // 便于观察，等待一段时间
                Thread.sleep(EXE_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
