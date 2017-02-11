
package xyz.codingmentor;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author mhorvath
 */
@Singleton
public class Flightmessages {
    List<String> messages=new ArrayList<>();

    public Flightmessages() {
    //empty on purpose
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
    public void addMessage(String message){
        messages.add(message);
    }
}
