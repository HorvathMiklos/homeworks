package xyz.codingmentor.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.rest.api.CRUDRestService;
import xyz.codingmentor.api.CRUDService;

/**
 * @author mhorvath
 */
@Produces(MediaType.APPLICATION_JSON)
public class GenericRESTService<T> implements CRUDRestService<T> {

    private final CRUDService<T> crudService;

    public GenericRESTService(CRUDService<T> crudService) {
        this.crudService = crudService;
    }

    @Override
    public Response createEntity(T entity) {
        crudService.createEntity(entity);
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getEntity(Long entityId) {
        T entity = crudService.getEntity(entityId);
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateEntity(T entity) {
        crudService.updateEntity(entity);
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response removeEntity(Long entityId) {
        T entity = crudService.removeEntity(entityId);
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }
}
