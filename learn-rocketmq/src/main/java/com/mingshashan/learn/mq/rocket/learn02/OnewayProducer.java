package com.mingshashan.learn.mq.rocket.learn02;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

public class OnewayProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer
                = new DefaultMQProducer("GID_TEST_ONEWAY_01");
        producer.setNamesrvAddr("localhost:9876");

        producer.start();

        String topic = "TOPIC_TEST_ONEWAY_01";
        String tags = "TAG_TEST_ONEWAY_01";
        String keys = "KEY_TEST_ONEWAY_01";


        for (int i = 0; i < 100; i++) {
            Message message = new Message(topic, tags, keys, ("msg" + i).getBytes(StandardCharsets.UTF_8));

            producer.sendOneway(message);
        }

        Thread.sleep(5000);
        producer.shutdown();
    }
}
