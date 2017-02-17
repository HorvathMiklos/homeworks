package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.api.CRUDRepoQualifier;
import xyz.codingmentor.api.CRUDServiceQualifier;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDServiceQualifier(EntityModel.CATEGORY)
public class CategoryService extends AbstractCRUDService<Category> implements CRUDService<Category> {

    public CategoryService() {
        super(null);
    }

    @Inject
    public CategoryService(@CRUDRepoQualifier(EntityModel.CATEGORY) CRUDRepository<Category> repository) {
        super(repository);
    }

}
