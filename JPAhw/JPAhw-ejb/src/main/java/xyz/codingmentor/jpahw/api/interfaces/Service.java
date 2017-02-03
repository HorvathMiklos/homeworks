package xyz.codingmentor.jpahw.api.interfaces;

/**
 *
 * @author mhorvath
 */
public interface Service<T> {
    void createEntity(T entity);
    T getEntityById(Long entityId);
    T updateEntity(T entity);
    void removeEntity(Long entityId);
}
