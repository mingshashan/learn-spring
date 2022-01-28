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

public class FilterProducer {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer(MQConstant.FILTER_PRODUCER_GROUP);

        producer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);

        producer.start();

        System.out.println("FILTER Message Producer Start");

        for (int i = 0; i < MQConstant.MSG_COUNT_1000; i++) {

            String tag = randomTag(i);

            Message message = new Message(MQConstant.FILTER_TOPIC,
                    tag,
                    "KEY-" + i,
                    ("Broadcasting Message , i-" + i).getBytes(StandardCharsets.UTF_8));

            message.putUserProperty(MQConstant.FILTER_PROPERTY_EVEN, i % 2 == 0 ? "true" : "false");

            SendResult sendResult = producer.send(message);

            System.out.println(sendResult);

            TimeUnit.MILLISECONDS.sleep(100);
        }

        producer.shutdown();

    }

    private static String randomTag(int i) {
        if (i % 13 == 0) {
            return MQConstant.FILTER_TAG_F;
        }
        if (i % 11 == 0) {
            return MQConstant.FILTER_TAG_E;
        }
        if (i % 7 == 0) {
            return MQConstant.FILTER_TAG_D;
        }
        if (i % 5 == 0) {
            return MQConstant.FILTER_TAG_C;
        }
        if (i % 3 == 0) {
            return MQConstant.FILTER_TAG_B;
        }
        if (i % 2 == 0) {
            return MQConstant.FILTER_TAG_A;
        }

        return MQConstant.FILTER_TAG_DEFAULT;
    }
}
