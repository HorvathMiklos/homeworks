package xyz.codingmentor;

import javax.ws.rs.Path;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.api.CRUDServiceQualifier;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("category")
public class CategoryResource extends AbstractRestService<Category> {

    @Inject
    public CategoryResource(@CRUDServiceQualifier(EntityModel.MOVIESTAR) CRUDService<Category> crudService) {
        super(crudService);
    }
}
