package com.mingshashan.learn.rabbitmq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * ActiveMQProvider
 *
 * @author jasonxu
 */
public class ActiveMQConsumer1 {
    public static void main(String[] args) {
        String brokerURL = "tcp://192.168.16.71:61616";
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(brokerURL);
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("jms");
            MessageConsumer messageConsumer = session.createConsumer(destination);


            while (true) {
                messageConsumer.setMessageListener(new MessageListener() {
                    @Override
                    public void onMessage(Message message) {
                        if (null == message) {
                            return;
                        }
                        ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
                        String text = null;
                        try {
                            text = textMessage.getText();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                        System.out.println(text);
                    }
                });
                session.commit();
//                session.close();
            }

//                session.close();


        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
