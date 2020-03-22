package com.mingshashan.learn.kafka.subscriber;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * MessageSubscriber
 *
 * @author jasonxu
 */
@Component
public class MessageSubscriber {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = {"${custom.kafka.topic}"}, groupId = "learn01")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) {
//        Book book = consumerRecord.value();
        String message = consumerRecord.value();

        logger.info("接受到的消息：{}", message);
    }
}
