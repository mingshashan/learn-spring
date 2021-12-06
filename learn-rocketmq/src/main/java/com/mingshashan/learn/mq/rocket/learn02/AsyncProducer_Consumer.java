package com.mingshashan.learn.mq.rocket.learn02;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.Charset;
import java.util.List;

public class AsyncProducer_Consumer {
    static String topic = "TOPIC_TEST_ASYNC_01";
    static String tags = "TAG_TEST_ASYNC_01";
    static String keys = "KEY_TEST_ASYNC_01";


    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer
                = new DefaultMQPushConsumer("GID_TEST_ASYNC_01");
        consumer.setNamesrvAddr("localhost:9876");


        consumer.subscribe(topic, "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                System.out.printf("%s receive message: %s \n",
                        Thread.currentThread().getName(), new String(msgs.get(0).getBody(), Charset.forName("UTF-8")));

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();

        System.out.println("consumer start");
    }
}
