package com.rgubaidullin;

import org.apache.activemq.command.ActiveMQDestination;

import javax.jms.*;


/**
 * Created by Renat_Gubaidullin on 8/28/2016.
 */
public class JMSModule {

    public JMSModule sendMessageJMS11(ConnectionFactory connectionFactory, final String queueName, String text) throws Exception {
        try {
            ActiveMQDestination destination = new ActiveMQDestination() {

                protected String getQualifiedPrefix() {
                    return null;
                }

                public byte getDestinationType() {
                    return 0;
                }

                public byte getDataStructureType() {
                    return 0;
                }
            };
            Queue queue = new Queue() {

                public String getQueueName() throws JMSException {
                    String name = queueName;
                    return name;
                }
            };
            Connection connection = connectionFactory.createConnection();
            try {
                Session session =connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue);
                TextMessage textMessage = session.createTextMessage(text);
                messageProducer.send(textMessage);
            } finally {
                connection.close();
            }
        } catch (JMSException ex) {
            // handle exception (details omitted)
        }
        return null;
    }

    public String receiveMessageJMS11(ConnectionFactory connectionFactory, Queue queue){
        String body=null;
        try {
            Connection connection = connectionFactory.createConnection();
            try {
                Session session =connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageConsumer messageConsumer = session.createConsumer(queue);
                connection.start();
                TextMessage textMessage = (TextMessage)messageConsumer.receive();
                body = textMessage.getText();
            } finally {
                connection.close();
            }
        } catch (JMSException ex) {
            // handle exception (details omitted)
        }
        return body;
    }
}
