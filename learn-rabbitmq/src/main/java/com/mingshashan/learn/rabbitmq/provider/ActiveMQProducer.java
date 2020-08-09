package com.mingshashan.learn.rabbitmq.provider;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQProvider
 *
 * @author jasonxu
 */
public class ActiveMQProducer {
    public static void main(String[] args) throws JMSException {
        String brokerURL = "tcp://192.168.16.71:61616";
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(brokerURL);
        Connection connection = null;

        try {

            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("jms2http");
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage message = session.createTextMessage("Hello World!");

            messageProducer.send(message);
            session.commit();
            session.close();
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
