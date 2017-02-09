
package xyz.codingmentor.api;

/**
 *
 * @author mhorvath
 */
public interface CRUDService<T> {
    void createEntity(T entity);    
    T getEntityById(Long entityId);    
    T updateEntity(T entity);    
    void removeEntity(Long entityId);
}
