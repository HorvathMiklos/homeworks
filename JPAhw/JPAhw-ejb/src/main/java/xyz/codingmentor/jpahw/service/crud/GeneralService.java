package xyz.codingmentor.jpahw.service.crud;

import xyz.codingmentor.jpahw.api.interfaces.Repository;

/**
 *
 * @author mhorvath
 */
public class GeneralService<T> {
    private final Repository<T> repository;
    
    public GeneralService(Repository<T> repository) {
        this.repository = repository;
    }

    public void createEntity(T entity) {
        repository.persist(entity);
    }

    public T getEntityById(Long entityId) {
        return repository.find(entityId);
    }

    public T updateEntity(T entity) {
        return repository.merge(entity);
    }

    public void removeEntity(Long entityId) {
        repository.remove(entityId);
    }
}
