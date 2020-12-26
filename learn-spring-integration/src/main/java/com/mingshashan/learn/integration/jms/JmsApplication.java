package com.mingshashan.learn.integration.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * JmsApplication
 *
 * @author xufj
 */
public class JmsApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jms-01.xml");

        MessageChannel channel = context.getBean("inboundChannel", MessageChannel.class);
//        MessageChannel channel = context.getBean("inputJmsChannel", MessageChannel.class);
//        channel.send(MessageBuilder.withPayload("h1").build());
//        channel.

//        for (int i = 0; i < 50; i++) {
//            System.out.println("channel send j" + i);
//            channel.send(MessageBuilder.withPayload("channel send j" + i).build());
//        }


        JmsMessageDrivenEndpoint gateway = context.getBean("jmsIn", JmsMessageDrivenEndpoint.class);

//        context.close();
    }
}
