package com.mingshashan.learn.netty.threadlocal;

import io.netty.util.concurrent.FastThreadLocal;

public class FastThreadLocalTest {
    private static final ThreadLocal<String> THREAD_NAME_LOCAL =
            ThreadLocal.withInitial(() -> Thread.currentThread().getName());
    private static final FastThreadLocal<TradeOrder> TRADE_THREAD_LOCAL = new FastThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int tradeId = i;
            new Thread(() -> {
                TradeOrder tradeOrder = new TradeOrder(tradeId, tradeId % 2 == 0 ? "已支付" : "未支付");
                TRADE_THREAD_LOCAL.set(tradeOrder);

                System.out.println("threadName = " + THREAD_NAME_LOCAL.get());
                System.out.println("tradeOrder Info = " + TRADE_THREAD_LOCAL.get());
            }, "thread-" + i).start();
        }
    }

    static class TradeOrder {
        long id;
        String status;

        public TradeOrder(long id, String status) {
            this.id = id;
            this.status = status;
        }

        @Override
        public String toString() {
            return "TradeOrder{" +
                    "id=" + id +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
