package com.mingshashan.learn.mq.rocket.learn02;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer
                = new DefaultMQProducer("GID_TEST_ASYNC_01");
        producer.setNamesrvAddr("localhost:9876");

        producer.start();
        producer.setRetryTimesWhenSendFailed(0);

        String topic = "TOPIC_TEST_ASYNC_01";
        String tags = "TAG_TEST_ASYNC_01";
        String keys = "KEY_TEST_ASYNC_01";


        final int count = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            Message message = new Message(topic, tags, keys, ("msg" + i).getBytes(StandardCharsets.UTF_8));
            int finalI = i;
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    countDownLatch.countDown();
                    System.out.printf("%s%n", sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    countDownLatch.countDown();
                    System.out.printf("%-10d Exception %s %n", finalI, e);
                    e.printStackTrace();
                }
            });

        }

        countDownLatch.await(5, TimeUnit.SECONDS);
        System.out.println("AsyncProducer send message over");
        producer.shutdown();
    }
}
