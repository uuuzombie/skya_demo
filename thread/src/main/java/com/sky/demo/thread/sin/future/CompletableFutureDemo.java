package com.sky.demo.thread.sin.future;

import com.sky.demo.thread.sin.future.service.HttpService;
import com.sky.demo.thread.sin.future.service.RpcService;
import org.apache.ibatis.executor.Executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 17/5/11.
 * 异步回调链式编排
 * JDK8 CompletableFuture
 * 使用场景：其实不是异步调用方式，只是对依赖多服务的Callback调用结果处理做结果编排，来弥补Callback的不足，从而实现全异步链式调用。
 */
public class CompletableFutureDemo {


    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();


    public static void main(String[] args) {

        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();

        try {
            long start = System.currentTimeMillis();
            //以Async结尾并且没有指定Executor的方法，会使用ForkJoinPool.commonPool()作为它的线程池执行异步代码。
            CompletableFuture<Integer> completableFutureRpc = CompletableFuture.supplyAsync(() -> {
                return rpcService.process();
            });

            CompletableFuture<Long> completableFutureHttp = CompletableFuture.supplyAsync(() -> {
                return httpService.process();
            }, EXECUTOR_SERVICE);

            long end = System.currentTimeMillis();
            System.out.println("take time:" + (end - start) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EXECUTOR_SERVICE.shutdown();
        }


    }
}
