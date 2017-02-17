
package xyz.codingmentor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("trailer")
public class TrailerResource {
    private final CRUDService<Trailer> trailerService;

    public TrailerResource() {
        trailerService = null;
    }
    
    
    @Inject
    public TrailerResource(@CRUDServiceQualifier(EntityModel.TRAILER) CRUDService<Trailer> trailerService) {
        this.trailerService = trailerService;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTrailer(Trailer trailer){
        trailerService.createEntity(trailer);
    }
    
    @GET
    @Path("/{id}")
    public Trailer getTrailerById(@PathParam("id") Long trailerId){
        return trailerService.getEntityById(trailerId);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Trailer updateTrailer(Trailer trailer){
        return trailerService.updateEntity(trailer);
    }
    @POST
    @Path("/delete/{id}")
    public void removeTrailer(@PathParam("id") Long entityId){
        trailerService.removeEntity(entityId);
    }
}
