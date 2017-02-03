package xyz.codingmentor.jpahw.api.interfaces;

/**
 *
 * @author mhorvath
 */
public interface Repository<T> {
    void persist(T entity);
    T find(Long entityId);
    T merge(T entity);
    void remove(Long entityId);
}
