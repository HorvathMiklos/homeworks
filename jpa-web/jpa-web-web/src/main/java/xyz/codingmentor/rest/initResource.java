package xyz.codingmentor.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import xyz.codingmentor.dbinit.DbInit;

/**
 * @author mhorvath
 */
@Path("initDB")
public class initResource {
    
    @Inject
    DbInit dbInit;
    
    @POST
    public void initDatabase(){
        dbInit.init();
    }
}
