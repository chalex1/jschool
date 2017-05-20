package tshop.front.controllers.message;

import javax.annotation.Resource;
import javax.jms.*;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.stereotype.Component;


/**
 * Created by Роднуля on 16.05.2017.
 */
    @Component
    public class MessageSender {


    @Resource(mappedName = "java:/ConnectionFactory")
    ConnectionFactory jmsConnectionFactory;

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String msg) {
        jmsTemplate.setConnectionFactory(jmsConnectionFactory);
        this.jmsTemplate.send( new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });

    }

    }

