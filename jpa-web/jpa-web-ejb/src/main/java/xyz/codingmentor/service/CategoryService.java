package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDRepositoryQualifier;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;

/**
 * @author mhorvath
 */
@Stateless
@CRUDServiceQualifier(EntityModel.CATEGORY)
public class CategoryService extends GenericCRUDService<Category> implements CRUDService<Category> {

    public CategoryService() {
        super(null);
    }

    @Inject
    public CategoryService(@CRUDRepositoryQualifier(EntityModel.CATEGORY) CRUDRepository<Category> repository) {
        super(repository);
    }
}
