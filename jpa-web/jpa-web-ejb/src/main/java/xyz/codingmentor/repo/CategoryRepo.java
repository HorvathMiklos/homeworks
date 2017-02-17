package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.api.CRUDRepoQualifier;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDRepoQualifier(EntityModel.CATEGORY)
public class CategoryRepo extends AbstractCRUDRepository<Category> implements CRUDRepository<Category> {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
