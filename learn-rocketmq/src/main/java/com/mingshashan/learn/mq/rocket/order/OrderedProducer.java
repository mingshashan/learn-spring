package com.mingshashan.learn.mq.rocket.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class OrderedProducer {


    public static void main(String[] args) throws Exception {

        final String MQ_GROUP = "GROUP_ORDER_01";
        final String MQ_TOPIC = "TOPIC_ORDER_01";

        MQProducer producer = new DefaultMQProducer(MQ_GROUP);
        producer.start();

        final String[] tags = new String[]{"TAG-A", "TAG-B", "TAG-C", "TAG-D", "TAG-E"};

        for (int i = 0; i < 100; i++) {
            int orderId = i % 10;
            Message message = new Message(
                    MQ_TOPIC, tags[i % tags.length],
                    ("KEY-" + ("Hello RocketMQ-" + i)).getBytes(StandardCharsets.UTF_8));

            SendResult sendResult = producer.send(message, (mqs, msg, arg) -> {

                Integer id = (Integer) arg;
                int index = id % mqs.size();

                return mqs.get(index);
            }, orderId);
        }
    }
}
