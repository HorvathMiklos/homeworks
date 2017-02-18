package xyz.codingmentor.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepository;

/**
 * @author mhorvath
 */
public abstract class AbstractCRUDRepository<T> implements CRUDRepository<T> {

    @PersistenceContext(unitName = "jpahwPU")
    private EntityManager entityManager;

    @Override
    public T persist(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T find(Long id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    @Override
    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public T remove(Long id) {
        T entity = find(id);
        getEntityManager().remove(find(id));
        return entity;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected abstract Class<T> getEntityClass();

}
