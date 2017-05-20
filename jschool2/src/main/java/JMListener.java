import javax.ejb.*;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Роднуля on 16.05.2017.
 */
@MessageDriven(name = "Listener", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topic/tshopnews"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class JMListener implements MessageListener {


    @Inject
    UpdateController updateController;

    @Override
    public void onMessage(Message message) {
        try {
            String txtmessage = message.getBody(String.class);
            System.out.println(getClass().getSimpleName() + " >>>>>>>> " + txtmessage);
            if (txtmessage.equals("checkit")) {
                updateController.update();
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
