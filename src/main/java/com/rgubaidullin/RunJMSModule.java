package com.rgubaidullin;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQDestination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Renat_Gubaidullin on 8/28/2016.
 */
public class RunJMSModule {
    public static void main(String[] args) throws Exception {
        String url;
        String user;
        String password;
        String queueName;
        String body;

        System.out.println("enter JMS url");
        BufferedReader reader_1 = new BufferedReader(new InputStreamReader(System.in));
        url = reader_1.readLine();

        System.out.println("enter user");
        BufferedReader reader_2 = new BufferedReader(new InputStreamReader(System.in));
        user = reader_2.readLine();

        System.out.println("enter password");
        BufferedReader reader_3 = new BufferedReader(new InputStreamReader(System.in));
        password = reader_3.readLine();

        System.out.println("enter queueName");
        BufferedReader reader_4 = new BufferedReader(new InputStreamReader(System.in));
        queueName = reader_4.readLine();

        System.out.println("enter body");
        BufferedReader reader_5 = new BufferedReader(new InputStreamReader(System.in));
        body = reader_5.readLine();

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url, user, password);

        JMSModule sendMessage = new JMSModule().sendMessageJMS11(connectionFactory,queueName,body);

    }

}
