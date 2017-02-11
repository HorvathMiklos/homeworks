
package xyz.codingmentor;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("flight")
@RequestScoped
public class FlightResource {
    @Inject
    FlightDB flightDB;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createFlight(Flight flight) {
        flightDB.createFlight(flight);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteFlight(@PathParam("id") String id){
        
        flightDB.deleteFlight(id);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editFlight(Flight flight) {
        flightDB.updateFlight(flight);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> getAllFlights() {
        return flightDB.listFlighs();
    }
    @GET
    @Path("date")
    @Produces(MediaType.APPLICATION_JSON)
    public Date getdate() {
        return new Date(); 
    }
    @GET
    @Path("flightformat")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight getflight() {
        Date now=new Date();
        return new Flight("BUD", "LAX", now, now);         
    }
}
