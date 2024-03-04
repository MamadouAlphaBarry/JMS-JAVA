package it.cws.meta;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main(String[] args)   {

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection= connectionFactory.createConnection();
            connection.start();
            Session session= connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Destination destination=session.createQueue("enset.queue");
            MessageProducer messageProducer= session.createProducer(destination);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message= session.createTextMessage();
            System.out.println("************envoie de message******************");
            message.setText("Hello depuis JMS server sur Rabbit");
            message.setText("Encore depuis JMS server sur Rabbit");
            messageProducer.send(message);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
