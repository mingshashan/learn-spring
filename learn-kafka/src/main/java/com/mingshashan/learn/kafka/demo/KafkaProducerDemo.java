package com.mingshashan.learn.kafka.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * KafkaProducerDemo
 *
 * @author jasonxu
 */
public class KafkaProducerDemo extends Thread {

    public static void main(String[] args) {
        new KafkaProducerDemo().start();
    }

    private final KafkaProducer<Integer, String> kafkaProducer;

    private final String topic;

    public KafkaProducerDemo() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.254.202:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

//        Producer<String, String> producer = new KafkaProducer<>(props);
//        kafkaProducer = new KafkaProducer<Integer, String>();
        kafkaProducer = new KafkaProducer<Integer, String>(props);
        this.topic = "test";
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ProducerRecord producerRecord = new ProducerRecord(topic, Integer.toString(i), Integer.toString(i));
            kafkaProducer.send(producerRecord);
        }
        kafkaProducer.close();
    }
}
