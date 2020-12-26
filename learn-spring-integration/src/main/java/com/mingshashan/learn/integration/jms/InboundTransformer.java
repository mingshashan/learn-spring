package com.mingshashan.learn.integration.jms;

import org.springframework.integration.transformer.Transformer;
import org.springframework.messaging.Message;

/**
 * InboundActivator
 *
 * @author xufj
 */
public class InboundTransformer implements Transformer {

    @Override
    public Message<?> transform(Message<?> message) {
        System.out.println("transform: " + message.getPayload());
        return message;
    }

//    public void print(String message) {
//        System.out.println("InboundActivator: " + message);
//    }

//    public void print(Message message) {
//        ActiveMQTextMessage mqTextMessage = (ActiveMQTextMessage)message;
//        try {
//            System.out.println(mqTextMessage.getText());
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }
}
