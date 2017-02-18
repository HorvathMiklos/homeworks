package xyz.codingmentor.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;

/**
 * @author mhorvath
 */
@Path("category")
public class CategoryResource extends GenericRESTService<Category> {

    @Inject
    public CategoryResource(@CRUDServiceQualifier(EntityModel.CATEGORY) CRUDService<Category> crudService) {
        super(crudService);
    }
}
