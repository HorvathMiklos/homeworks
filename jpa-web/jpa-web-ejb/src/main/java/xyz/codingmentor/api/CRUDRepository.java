package xyz.codingmentor.api;

/**
 * @author mhorvath
 */
public interface CRUDRepository<T> {

    T persist(T entity);

    T find (Long id);
    
    T merge(T entity);
    
    T remove(Long id);
}
