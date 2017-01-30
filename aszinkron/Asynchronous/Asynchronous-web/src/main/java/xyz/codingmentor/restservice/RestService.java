
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
    
    @GET
    @Path("/five")
    public String five() {        
        Integer returnValue=null;        
        Future<Integer> result = asynch.inefectivlyReturnFive();        
        try {
            returnValue = result.get();
        } catch (InterruptedException | ExecutionException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }        
        return "five="+returnValue.toString();
    }
    
    @GET
    @Path("/nothing")
    public String nothing(){
        LOGGER.log(Level.INFO,"nothing started");
        asynch.doNothingForALongTime();
        LOGGER.log(Level.INFO,"nothing stopped");
        return "we did nothing for a long time but at least asynchronously";
    }
}
