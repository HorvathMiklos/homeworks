
package xyz.codingmentor;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("messagelist")
@RequestScoped
public class MessagelistResource {
    @Inject
    Flightmessages flightmessages;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Flightmessages getAllMessages() {
      return flightmessages;
    }

   
}
