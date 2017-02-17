
package xyz.codingmentor.repo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepository;

/**
 *
 * @author mhorvath
 */
public abstract class AbstractCRUDRepository<T> implements CRUDRepository<T>{
    @PersistenceContext(unitName = "jpawebhwPU")
    private EntityManager entityManager;
    private static final Logger LOGGER=Logger.getLogger(AbstractCRUDRepository.class.getName());
        
    @Override
    public void persist(T entity) {        
        LOGGER.log(Level.INFO, "entity test log: "+ entity.toString());
        LOGGER.log(Level.INFO, "entitymanager test log: "+ getEntityManager().toString());
        getEntityManager().persist(entity);        
    }
    @Override
    public T find(Long entityId) {
        return getEntityManager().find(getEntityClass(), entityId);
    }
    @Override
    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }
    @Override
    public void remove(Long entityId) {
        getEntityManager().remove(find(entityId));
    }

    protected abstract Class<T> getEntityClass();
    
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
