package com.mingshashan.learn.mq.rocket.learn01;

import com.mingshashan.learn.mq.rocket.MQConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer
                = new DefaultMQProducer(MQConstant.SIMPLE_PRODUCER_GROUP);
        producer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);

        producer.start();
        producer.setSendMsgTimeout(1000000);
        producer.setRetryTimesWhenSendFailed(0);

        for (int i = 0; i < MQConstant.MSG_COUNT_100; i++) {

            Message message = new Message(MQConstant.SIMPLE_TOPIC,
                    MQConstant.SIMPLE_TAG1,
                    "KEY-" + i,
                    ("simple-msg-" + i).getBytes(StandardCharsets.UTF_8));

            final int finalI = i;
            SendResult sendResult = producer.send(message, 1000000);

            System.out.println(sendResult);
            TimeUnit.MILLISECONDS.sleep(200);
        }

        System.out.println("AsyncProducer send message over");
        producer.shutdown();
    }
}
