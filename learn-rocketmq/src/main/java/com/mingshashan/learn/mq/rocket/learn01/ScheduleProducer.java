package com.mingshashan.learn.mq.rocket.learn01;

import com.mingshashan.learn.mq.rocket.MQConstant;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class ScheduleProducer {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer(MQConstant.SCHEDULE_PRODUCER_GROUP);

        producer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);

        producer.start();

        System.out.println("Schedule Message Producer Start");

        for (int i = 0; i < MQConstant.MSG_COUNT_100; i++) {
            Message message = new Message(MQConstant.SCHEDULE_TOPIC,
                    "schedule-test-tag-" + i, "KEY-" + i,
                    ("Broadcasting Message , i-" + i).getBytes(StandardCharsets.UTF_8));

            if (i % 2 == 0) {
                message.setDelayTimeLevel(2);
            }

            if (i % 3 == 0) {
                message.setDelayTimeLevel(3);
            }

            if (i % 5 == 0) {
                message.setDelayTimeLevel(5);
            }

            if (i % 7 == 0) {
                message.setDelayTimeLevel(7);
            }

            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
            TimeUnit.SECONDS.sleep(1);
        }

        producer.shutdown();

    }
}
