package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDRepositoryQualifier;
import xyz.codingmentor.api.EntityModel;

/**
 * @author mhorvath
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.CATEGORY)
public class CategoryRepo extends AbstractCRUDRepository<Category> implements CRUDRepository<Category> {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

}
