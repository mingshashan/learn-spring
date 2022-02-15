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

public class BroadcastingProducer {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer(MQConstant.BROADCASTING_PRODUCER_GROUP);

        producer.setNamesrvAddr(MQConstant.NAME_SRV_ADDR);
        producer.start();
        System.out.println("Broadcasting Producer start");

        int i = 0;
        while (i < MQConstant.MSG_COUNT_10 + 5) {


            Message message = new Message(MQConstant.BROADCASTING_TOPIC, i % 2 == 0 ? MQConstant.BROADCASTING_TAG2 :
                    MQConstant.BROADCASTING_TAG1, "KEY-" + i,
                    ("Broadcasting Message , i " + i).getBytes(StandardCharsets.UTF_8));

            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
            TimeUnit.SECONDS.sleep(1);
            i++;
        }

        producer.shutdown();
    }
}
