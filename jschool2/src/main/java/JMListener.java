import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Роднуля on 16.05.2017.
 */
public class JMListener {
    @MessageDriven(name = "Listener", activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topic/js-topic"),
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
            @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
    public class FirstListener implements MessageListener {

        @Override
        public void onMessage(Message message) {
            try {
                System.out.println(getClass().getSimpleName() + " >>>>>>>> " + message.getBody(String.class));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
