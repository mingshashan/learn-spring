package com.mingshashan.learn.mq.rocket.learn01;

import com.mingshashan.learn.mq.rocket.MQConstant;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BatchProducer {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer(MQConstant.BATCH_PRODUCER_GROUP);

        producer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);

        producer.start();

        System.out.println("Batch Message Producer Start");

        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < MQConstant.MSG_COUNT_1000; i++) {
            Message message = new Message(MQConstant.BATCH_TOPIC,
                    i % 2 == 0 ? MQConstant.BATCH_TAG2 : MQConstant.BATCH_TAG1,
                    "KEY-" + i,
                    ("Broadcasting Message , i-" + i).getBytes(StandardCharsets.UTF_8));

            messageList.add(message);

            // TimeUnit.MILLISECONDS.sleep(100);
        }

        SendResult sendResult = producer.send(messageList);
        System.out.println(sendResult);
        messageList.clear();
        producer.shutdown();

    }
}
