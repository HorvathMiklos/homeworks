
package xyz.codingmentor.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.model.Category;

/**
 *
 * @author mhorvath
 */

public class CategoryRepo extends AbstractCRUDRepository<Category> implements CRUDRepository<Category>{
    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    
    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
