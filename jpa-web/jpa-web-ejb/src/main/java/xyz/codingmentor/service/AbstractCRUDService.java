
package xyz.codingmentor.service;

import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;

/**
 *
 * @author mhorvath
 */
public abstract class AbstractCRUDService<T> implements CRUDService<T>{
    private final CRUDRepository<T> repository;

    public AbstractCRUDService(CRUDRepository<T> repository) {
        this.repository = repository;
    }
    
    @Override
    public void createEntity(T entity) {
        repository.persist(entity);
    }

    @Override
    public T getEntityById(Long entityId) {
        return repository.find(entityId);
    }

    @Override
    public T updateEntity(T entity) {
        return repository.merge(entity);
    }

    @Override
    public void removeEntity(Long entityId) {
        repository.remove(entityId);
    }

}
