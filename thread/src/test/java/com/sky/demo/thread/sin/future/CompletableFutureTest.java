package com.sky.demo.thread.sin.future;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by user on 17/5/16.
 */
public class CompletableFutureTest {

    @Test
    public void test_completedFuture() throws ExecutionException, InterruptedException {

        //completedFuture()返回一个已经计算好的CompletableFuture
        CompletableFuture<Integer> future = CompletableFuture.completedFuture(100);

        System.out.println(future.get());
    }

    @Test
    public void test_get() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });

        //CompletableFuture类实现了CompletionStage和Future接口，所以还是可以像以前一样通过阻塞或者轮询的方式获得结果
        Integer result = future.get();
        System.out.println(result);
    }

    @Test
    public void test_join() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });

        //join返回计算的结果或者抛出一个unchecked异常(CompletionException)，它和get对抛出的异常的处理有些细微的区别
        Integer result = future.join();
        System.out.println(result);
    }

    @Test
    public void test_getNow() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(

                () -> {
            int i = 1 / 10;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        //getNow(),如果结果已经计算完则返回结果或者抛出异常，否则返回给定的valueIfAbsent值。
        Integer result = future.getNow(-1);
        while (result == -1) {
            System.out.println(result);
            result = future.getNow(-1);
        }
        System.out.println(result);
    }


    @Test
    public void test_runAsync() {
        //以Async结尾并且没有指定Executor的方法，会使用ForkJoinPool.commonPool()作为它的线程池执行异步代码。
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xxx");
        });

//        future.join();
        System.out.println("complete");
        future.join();

    }

    @Test
    public void test_supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            //长时间的计算任务
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 100;
        });

        Integer result = future.get();

    }

    @Test
    public void test_whenComplete() throws ExecutionException, InterruptedException {
        System.out.println("test=" + Thread.currentThread().getName());

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        //whenComplete() 方法不以Async结尾，意味着Action使用相同的线程执行
        CompletableFuture<Integer> futureResult = future.whenComplete((value, throwable) -> {
            System.out.println("whenComplete=" + Thread.currentThread().getName());

            if (throwable != null) {
                System.out.println("error" + throwable);
            }
            System.out.println(value);
        });

        System.out.println(futureResult.get());  //需要get()阻塞
    }

    @Test
    public void test_whenCompleteAsync() throws ExecutionException, InterruptedException {
        System.out.println("test=" + Thread.currentThread().getName());

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        //whenCompleteAsync() 可能会使用其它的线程去执行(如果使用相同的线程池，也可能会被同一个线程选中执行)。
        CompletableFuture<Integer> futureResult = future.whenCompleteAsync((value, throwable) -> {
            System.out.println("whenComplete=" + Thread.currentThread().getName());

            if (throwable != null) {
                System.out.println("error" + throwable);
            }
            System.out.println(value);
        });

        System.out.println(futureResult.get());  //需要get()阻塞
    }

    @Test
    public void test_exceptionally() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 1 / 0;
            return result;
        });

        //exceptionally方法返回一个新的CompletableFuture
        //当原始的CompletableFuture抛出异常的时候，就会触发这个CompletableFuture的计算
        CompletableFuture<Integer> futureResult = future.exceptionally(throwable -> {
            System.out.println("error : " + throwable);
            return 0;
        });


        Integer result = futureResult.get();
        System.out.println(result);
    }


    @Test
    public void test_thenApplyAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
           return 100;
        });

        //thenApply方法只是用来处理正常值，因此一旦有异常就会抛出
        CompletableFuture<Long> futureLong = future.thenApplyAsync(i -> i / 0).thenApply(i -> i * 20L);


        Long result = futureLong.get();
        System.out.println(result);
    }


    @Test
    public void test_thenAcceptAsync() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });

        CompletableFuture<Void> futureResult = future.thenAcceptAsync(System.out::println);

    }

    @Test
    public void test_thenAcceptBothAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });

        CompletableFuture<Void> futureResult = future.thenAcceptBothAsync(CompletableFuture.completedFuture(100),
                (x, y) -> System.out.println(x + y));

        Void aVoid = futureResult.get();
        System.out.println(aVoid);
    }


    @Test
    public void test_thenRunAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        future.thenRun(() -> System.out.println("finished"));

        future.get();

    }


    @Test
    public void test_allOf() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 finish");
            return 100;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2 finish");
            return "OK";
        });

        //allOf方法是当所有的CompletableFuture都执行完后执行计算。
        CompletableFuture<Void> future = CompletableFuture.allOf(future1, future2);

        future.get();
//        future.join();

    }

    @Test
    public void test_anyOf() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 finish");
            return 100;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2 finish");
            return "OK";
        });

        //anyOf方法是当任意一个CompletableFuture执行完后就会执行计算，计算的结果相同。
        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2);

        future.get();
//        future.join();

    }




}
