package com.mingshashan.learn.mq.rocket.learn02;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

public class SyncProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer
                = new DefaultMQProducer("GID_TEST_SYNC_01");
        producer.setNamesrvAddr("localhost:9876");

        producer.start();

        String topic = "TOPIC_TEST_SYNC_01";
        String tags = "TAG_TEST_SYNC_01";
        String keys = "KEY_TEST_SYNC_01";


        for (int i = 0; i < 100; i++) {
            Message message = new Message(topic,tags,keys, ("msg" + i).getBytes(StandardCharsets.UTF_8));

            SendResult sendResult = producer.send(message);

            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();
    }
}
