package com.mingshashan.learn.mq.rocket.learn01;

import com.mingshashan.learn.mq.rocket.MQConstant;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * order message producer
 */
public class OrderProducer {

    private final static int COUNT = 1000;

    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    private static final BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(50);

    private static final ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            SecurityManager s = System.getSecurityManager();
            ThreadGroup group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            String namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";

            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    };

    private static final RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!executor.isShutdown()) {
                BlockingQueue<Runnable> queue = executor.getQueue();
                try {
                    queue.offer(r, 1000, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.err.println("等待时间过久");
                    throw new RejectedExecutionException("Interrupted", e);
                }
            }
        }
    };

    private static ExecutorService executorService = new ThreadPoolExecutor(1, 2, 1000 * 60,
            TimeUnit.MILLISECONDS, blockingQueue, threadFactory, rejectedExecutionHandler);


    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer(MQConstant.ORDER_GROUP);
        producer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);


        producer.start();

        for (int i = 0; i < COUNT; i++) {
            int orderId = i % 10;
            String tag = i % 2 == 0 ? MQConstant.ORDER_TAG2 : MQConstant.ORDER_TAG1;
            Message msg = new Message(MQConstant.ORDER_TOPIC, tag, "KEY" + i,
                    ("Hello RocketMQ, order- " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, orderId);

            System.out.printf("%s\n", sendResult);
            TimeUnit.SECONDS.sleep(1);
        }

        producer.shutdown();
    }


}
