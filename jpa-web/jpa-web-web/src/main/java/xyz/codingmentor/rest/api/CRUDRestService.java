package xyz.codingmentor.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author mhorvath
 */
@Produces(MediaType.APPLICATION_JSON)
public interface CRUDRestService<T> {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response createEntity(T entity);

    @GET
    @Path("/{id}")
    Response getEntity(@PathParam("id") Long entityId);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateEntity(T entity);

    @POST
    @Path("delete/{id}")
    Response removeEntity(@PathParam("id") Long entityId);
}
