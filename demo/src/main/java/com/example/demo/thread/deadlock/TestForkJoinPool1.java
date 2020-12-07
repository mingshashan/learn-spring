package com.example.demo.thread.deadlock;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 测试 ForkJoinPool 线程池的使用
 *
 * @author ConstXiong
 * @date 2019-06-12 12:05:55
 */
public class TestForkJoinPool1 {

    public static void main(String[] args) throws Exception {
        testNoResultTask();//测试使用 ForkJoinPool 无返回值的任务执行
    }

    /**
     * 测试使用 ForkJoinPool 无返回值的任务执行
     *
     * @throws Exception
     */
    public static void testNoResultTask() throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(1, 200));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}

/**
 * 无返回值的打印任务
 *
 * @author ConstXiong
 * @date 2019-06-12 12:07:02
 */
class PrintTask extends RecursiveAction {

    private static final long serialVersionUID = 1L;
    private static final int THRESHOLD = 49;
    private int start;
    private int end;

    public PrintTask(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }


    @Override
    protected void compute() {
        //当结束值比起始值 大于 49 时，按数值区间平均拆分为两个任务；否则直接打印该区间的值
        if (end - start < THRESHOLD) {
            for (int i = start; i <= end; i++) {
                System.out.println(Thread.currentThread().getName() + ", i = " + i);
            }
        } else {
            int middle = (start + end) / 2;
            PrintTask firstTask = new PrintTask(start, middle);
            PrintTask secondTask = new PrintTask(middle + 1, end);
            firstTask.fork();
            secondTask.fork();

        }
    }

}
