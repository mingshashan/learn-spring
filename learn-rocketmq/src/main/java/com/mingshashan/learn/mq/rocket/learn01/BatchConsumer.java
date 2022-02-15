package com.mingshashan.learn.mq.rocket.learn01;

import com.mingshashan.learn.mq.rocket.MQConstant;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class BatchConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(MQConstant.BATCH_CONSUMER_GROUP);

        consumer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);

        // consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(MQConstant.BATCH_TOPIC, "*");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                if (CollectionUtils.isNotEmpty(msgs)) {
                    System.out.printf("msgs.size() = [%d]\t", msgs.size());
                    MessageExt messageExt = msgs.get(0);

                    System.out.printf("topic = [%s]\ttags = [%s]\tmsgKey = [%s]\tbody=[%s]\n",
                            messageExt.getTopic(), messageExt.getTags(), messageExt.getKeys(),
                            new String(messageExt.getBody(), StandardCharsets.UTF_8));
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
        System.out.println("BATCH Producer start");
    }

}
