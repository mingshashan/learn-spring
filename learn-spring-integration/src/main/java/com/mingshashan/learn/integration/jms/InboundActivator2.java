package com.mingshashan.learn.integration.jms;

/**
 * InboundActivator
 *
 * @author xufj
 */
public class InboundActivator2 {

    public void print(String message) {
        System.out.println("InboundActivator2: " + message);
    }

//    public void print(Message message) {
//        ActiveMQTextMessage mqTextMessage = (ActiveMQTextMessage)message;
//        try {
//            System.out.println(mqTextMessage.getText());
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }
}
