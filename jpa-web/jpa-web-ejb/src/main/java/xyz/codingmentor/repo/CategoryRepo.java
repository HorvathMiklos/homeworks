
package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDRepo(EntityModel.CATEGORY)
public class CategoryRepo extends AbstractCRUDRepository<Category> implements CRUDRepository<Category>{
    @PersistenceContext(unitName = "jpawebhwPU")
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
