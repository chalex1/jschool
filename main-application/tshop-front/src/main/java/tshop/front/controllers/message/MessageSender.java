package tshop.front.controllers.message;

import javax.annotation.Resource;
import javax.jms.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Роднуля on 16.05.2017.
 */
    @Component
    public class MessageSender {

        @Autowired

        private JMSContext context;

    @Resource(mappedName = "java:/jms/topic/js-topic")
    private Topic topic;

    public void sendGettingGoods() {
        System.out.println("Sending " + "gettng goods");
        context.createProducer().send(topic, "Goods was getted");
    }

    }

