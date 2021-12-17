package com.mingshashan.learn.hello.thread;

import java.util.concurrent.*;

public class Future01 {

    private static volatile int a = 0;

    public static void main(String[] args) {

        FutureTask<String> future =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {

                        while (true) {
                            // TimeUnit.SECONDS.sleep(5);
                            if (a == 1) {
                                Thread.currentThread().interrupt();
                                TimeUnit.SECONDS.sleep(5);
                            }
                            if (a == 2) {
                                return "haha";
                            }


                        }
                    }
                });
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(future);

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(1);
            long start = System.currentTimeMillis();
            a = 1;
            String result = future.get();
            System.out.println(2);
            long end = System.currentTimeMillis();

            System.out.printf("cost time = [%d]", (end - start));
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
