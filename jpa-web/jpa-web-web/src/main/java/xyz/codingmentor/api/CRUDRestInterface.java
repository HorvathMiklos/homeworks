package xyz.codingmentor.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mhorvath
 */
@Produces(MediaType.APPLICATION_JSON)
public interface CRUDRestInterface<T> {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void createEntity(T entity);

    @POST
    @Path("delete/{id}")
    void removeEntity(@PathParam("id") Long entityId);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    T getEntity(@PathParam("id") Long entityId);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    T updateEntity(T entity);

}
