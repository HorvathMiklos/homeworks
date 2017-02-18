package xyz.codingmentor;

import javax.ws.rs.core.Response;
import xyz.codingmentor.api.CRUDRestInterface;
import xyz.codingmentor.api.CRUDService;

/**
 *
 * @author mhorvath
 */
public class AbstractRestService<T> implements CRUDRestInterface<T> {

    private final CRUDService<T> crudService;

    public AbstractRestService(CRUDService<T> crudService) {
        this.crudService = crudService;
    }

    @Override
    public void createEntity(T entity) {
       crudService.createEntity(entity);
       Response.ok("Entity Created").build();
    }

    @Override
    public void removeEntity(Long entityId) {
       crudService.removeEntity(entityId);
       Response.ok("Entity Removed").build();
    }

    @Override
    public T getEntity(Long entityId) {
        return crudService.getEntityById(entityId);
    }

    @Override
    public T updateEntity(T entity) {
        return crudService.updateEntity(entity);
    }

}
