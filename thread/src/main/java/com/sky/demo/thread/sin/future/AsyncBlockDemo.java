package com.sky.demo.thread.sin.future;

import com.google.common.util.concurrent.Futures;
import com.sky.demo.thread.sin.future.service.HttpService;
import com.sky.demo.thread.sin.future.service.RpcService;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by user on 17/5/11.
 * 异步阻塞
 * 半异步
 * 线程池，异步Future
 * 使用场景：并发请求多服务，总耗时为最长响应时间;提升总响应时间，但是阻塞主请求线程，高并发时依然会造成线程数过多，CPU上下文切换;
 */
public class AsyncBlockDemo {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();


    public static void main(String[] args) {

        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();

        try {
            long start = System.currentTimeMillis();
            Future<Integer> futureRpc = EXECUTOR_SERVICE.submit(() -> {
                return rpcService.process();
            });

            Future<Long> futureHttp = EXECUTOR_SERVICE.submit(() -> {
                return httpService.process();
            });

            Integer integer = futureRpc.get();
            System.out.println(integer);

            Long value = futureHttp.get();
            System.out.println(value);

            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EXECUTOR_SERVICE.shutdown();
        }


    }
}
