package com.example.demo.thread.deadlock;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 测试 ForkJoinPool 线程池的使用
 *
 * @author ConstXiong
 * @date 2019-06-12 12:05:55
 */
public class TestForkJoinPool {

    public static void main(String[] args) throws Exception {
        testHasResultTask();//测试使用 ForkJoinPool 有返回值的任务执行，对结果进行合并。计算 1 到 200 的累加和
    }

    /**
     * 测试使用 ForkJoinPool 有返回值的任务执行，对结果进行合并。计算 1 到 200 的累加和
     *
     * @throws Exception
     */
    public static void testHasResultTask() throws Exception {
        int result1 = 0;
        for (int i = 1; i <= 200; i++) {
            result1 += i;
        }
        System.out.println("循环计算 1-200 累加值：" + result1);

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new CalculateTask(1, 200));
        int result2 = task.get();
        System.out.println("并行计算 1-200 累加值：" + result2);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }

}

/**
 * 有返回值的计算任务
 *
 * @author ConstXiong
 * @date 2019-06-12 12:07:25
 */
class CalculateTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1L;
    private static final int THRESHOLD = 49;
    private int start;
    private int end;

    public CalculateTask(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        //当结束值比起始值 大于 49 时，按数值区间平均拆分为两个任务，进行两个任务的累加值汇总；否则直接计算累加值
        if (end - start <= THRESHOLD) {
            int result = 0;
            for (int i = start; i <= end; i++) {
                result += i;
            }
            return result;
        } else {
            int middle = (start + end) / 2;
            CalculateTask firstTask = new CalculateTask(start, middle);
            CalculateTask secondTask = new CalculateTask(middle + 1, end);
            firstTask.fork();
            secondTask.fork();
            return firstTask.join() + secondTask.join();
        }
    }

}