package xyz.codingmentor.jpahw.repository.crud;

import javax.persistence.EntityManager;

/**
 *
 * @author mhorvath
 */
public abstract class AbstractRepository<T> {

    public AbstractRepository() {
    }
    public void persist(T entity) {
        getEntityManager().persist(entity);
    }

    public T find(Long entityId) {
        return getEntityManager().find(getEntityClass(), entityId);
    }

    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    public void remove(Long entityId) {
        getEntityManager().remove(find(entityId));
    }

    protected abstract Class<T> getEntityClass();
    
    protected abstract EntityManager getEntityManager();

}
