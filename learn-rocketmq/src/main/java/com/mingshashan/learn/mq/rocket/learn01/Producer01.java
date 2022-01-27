package com.mingshashan.learn.mq.rocket.learn01;

import com.mingshashan.learn.mq.rocket.MQConstant;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

public class Producer01 {

    static int flag = 10000;

    public static void main(String[] args) throws MQClientException, InterruptedException, RemotingException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producer_group01");

        producer.setNamesrvAddr("192.168.75.129:9876");

        producer.start();

        int count = 1;
        String bodyId = "";

        while (count <= flag) {
            Thread.sleep(2000);
            bodyId = "id-" + count;
            String body = "Message Body " + count++;
            Message message = new Message();
            message.setTopic(MQConstant.TOPIC);
            message.setTags(MQConstant.TAG);
            message.setBuyerId(bodyId);
            message.setBody(body.getBytes(StandardCharsets.UTF_8));

            SendResult sendResult = producer.send(message);
            System.out.printf("send message result = [%s]\n",
                    sendResult);

        }

        producer.shutdown();

    }
}
