package com.mingshashan.learn.kafka.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * KafkaSendMessageController
 *
 * @author jasonxu
 */
@RestController
@RequestMapping("/kafka-send-ms")
public class KafkaSendMessageController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSendMessageController.class);

    private final KafkaTemplate kafkaTemplate;

    @Value("${custom.kafka.topic:test}")
    private String topic;

    public KafkaSendMessageController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping()
    public void sendMessage(@RequestParam("message") String message) throws ExecutionException, InterruptedException {

        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, message);

        logger.info("开始发送消息：{}", message);
        ListenableFuture<SendResult<String, String>> feature = kafkaTemplate.send(producerRecord);
//        SendResult<String, Book> sendResult = feature.get();
//        RecordMetadata recordMetadata = sendResult.getRecordMetadata();
        feature.addCallback((SuccessCallback) result -> {

            logger.info("消息发送成功：{}", ((SendResult)result).getProducerRecord().value());
        }, ex -> {
            logger.error("消息发送失败！", ex);
        });
    }

//    @PostMapping("/book")
//    public void sendMessage(@RequestBody Book book) throws ExecutionException, InterruptedException {
//
//        ProducerRecord<String, Book> producerRecord = new ProducerRecord<>(topic, book);
//
//        logger.info("开始发送消息：{}", book);
//        ListenableFuture<SendResult<String, Book>> feature = kafkaTemplate.send(producerRecord);
////        SendResult<String, Book> sendResult = feature.get();
////        RecordMetadata recordMetadata = sendResult.getRecordMetadata();
//        feature.addCallback((SuccessCallback) result -> {
//            logger.info("消息发送成功：{}", result.toString());
//        }, ex -> {
//            logger.error("消息发送失败！", ex);
//        });
//    }
}
