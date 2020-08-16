package com.mingshashan.learn.netty.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Test
 *
 * @author jasonxu
 */
public class Test {

    public static void main(String[] args) {
        ExecutorService pool =
                Executors.newFixedThreadPool(10);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Callable<String> callable = new Callable() {
                @Override
                public String call() throws Exception {
                    return "hello world" + finalI;
                }
            };
            futures.add(pool.submit(callable));
        }

        pool.shutdown();
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
