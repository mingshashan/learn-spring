package com.mingshashan.learn.mq.rocket.learn01;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;

public class Consumer01 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setConsumerGroup(MQConstant01.CONSUMER_GROUP);
        consumer.setNamesrvAddr("192.168.75.129:9876");

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe(MQConstant01.TOPIC, "*");

        consumer.setMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {

            try {
                for (MessageExt messageExt : list) {
                    String messageBody = new String(messageExt.getBody(), StandardCharsets.UTF_8);
                    String messageId = messageExt.getMsgId();

                    System.out.printf("messageId = [%s], messageBody = [%s]\n",
                            messageId, messageBody);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }

            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();

        System.out.printf("RocketMQ consumer start.\n");
    }
}
