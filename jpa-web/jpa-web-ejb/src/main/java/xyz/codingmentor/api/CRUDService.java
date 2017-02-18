package xyz.codingmentor.api;

/**
 * @author mhorvath
 */
public interface CRUDService <T> {
    
    T createEntity(T entity);

    T getEntity(Long id);
    
    T updateEntity(T entity);
    
    T removeEntity(Long id);
}
