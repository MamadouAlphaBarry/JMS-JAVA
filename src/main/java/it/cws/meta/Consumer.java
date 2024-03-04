package it.cws.meta;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) throws JMSException {

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            System.out.println("server demarer sur le port tcp://localhost:61616");
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("enset.queue");
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {

                        try {
                            TextMessage textMessage = (TextMessage) message;
                            System.out.println("*******reception de message***************");
                            System.out.println(textMessage.getText());
                        } catch (JMSException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        } finally {

        }
    }
}