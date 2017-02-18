package xyz.codingmentor.service;

import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;

/**
 * @author mhorvath
 */
public abstract class GenericCRUDService<T> implements CRUDService<T>{

    private final CRUDRepository<T> repository;

    public GenericCRUDService(CRUDRepository<T> repository){
        this.repository = repository;
    }

    @Override
    public T createEntity(T entity) {
        repository.persist(entity);
        return entity;
    }

    @Override
    public T getEntity(Long id) {
        return repository.find(id);
    }
    
    @Override
    public T updateEntity(T entity){
        return repository.merge(entity);
    }
    
    @Override
    public T removeEntity(Long id){
        return repository.remove(id);
    }
    
}
