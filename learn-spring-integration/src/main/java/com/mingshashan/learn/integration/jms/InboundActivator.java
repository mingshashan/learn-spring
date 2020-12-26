package com.mingshashan.learn.integration.jms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * InboundActivator
 *
 * @author xufj
 */
public class InboundActivator {

    public void print(String message) {

        Collections.synchronizedList(new ArrayList<>());
        System.out.println("InboundActivator: " + message);
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
