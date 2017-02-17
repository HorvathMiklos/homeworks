
package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecification;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDSpecification(EntityModel.CATEGORY)
public class CategoryService extends AbstractCRUDService<Category> implements CRUDService<Category>{

    public CategoryService() {
        super(null);
    }
    
    @Inject
    public CategoryService(@CRUDRepo(EntityModel.CATEGORY) CRUDRepository<Category> repository) {
        super(repository);
    }
    
}
