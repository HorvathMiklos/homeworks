
package xyz.codingmentor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author mhorvath
 */
@MessageDriven(mappedName = "jms/flight" )
public class MessageDrivenFlightObserver implements MessageListener{
    @Inject
    Flightmessages flightmessages;
    
    private static final Logger LOGGER=Logger.getLogger(MessageDrivenFlightObserver.class.getName());
    public MessageDrivenFlightObserver() {
        //empty on purpose
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            flightmessages.addMessage(message.getBody(String.class));
            LOGGER.log(Level.INFO, message.getBody(String.class));
        } catch (JMSException ex) {
            Logger.getLogger(MessageDrivenFlightObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
