
package xyz.codingmentor.restservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.asynchservice.Asynch;

/**
 *
 * @author mhorvath
 */

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class RestService {
    private static final Logger LOGGER = Logger.getLogger(RestService.class.getSimpleName());
    @Inject
    private Asynch asynch;
    /**
     * send back this text: five=5
     * Log demonstrates it is asynchronous, because it can ran at the same time with my other method.  
     * This method uses the inefectivlyReturnFive method. this method returns with Future<Integer> type.
     * This contains the return value of our asynchronous method.
     * http://localhost:8080/Asynchronous-web/five
     */
    @GET
    @Path("/five")
    public String five() {        
        Integer returnValue=0;        
        Future<Integer> result;
        
        result= asynch.inefectivlyReturnFive();        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOGGER.log(Level.INFO,"demonstrate asynchronous");
        try {
            returnValue = result.get();
        } catch (InterruptedException | ExecutionException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
       
        return "five="+returnValue.toString();
    }
    /**
     * send text to client: "we did nothing for a long time but at least asynchronously"
     * Log demonstrates it is asynchronous, because it can ran at the same time with my other method.  
     * Thread sleep for 5 seconds.
     * http://localhost:8080/Asynchronous-web/nothing
     */
    @GET
    @Path("/nothing")
    public String nothing(){        
        asynch.doNothingForALongTime();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOGGER.log(Level.INFO,"demonstrate asynchronous");
        return "we did nothing for a long time but at least asynchronously";
    }
}
