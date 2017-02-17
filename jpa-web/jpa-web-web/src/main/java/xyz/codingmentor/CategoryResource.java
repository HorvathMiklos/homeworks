package xyz.codingmentor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
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
public class CategoryResource {

    private final CRUDService<Category> categoryService;

    @Inject
    public CategoryResource(@CRUDServiceQualifier(EntityModel.CATEGORY) CRUDService<Category> categoryService) {
        this.categoryService = categoryService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCategory(Category category) {
        categoryService.createEntity(category);
    }

    @GET
    @Path("/{id}")
    public Category getCategoryById(@PathParam("id") Long entityId) {
        return categoryService.getEntityById(entityId);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Category updateCategory(Category category) {
        return categoryService.updateEntity(category);
    }

    @POST
    @Path("/delete/{id}")
    public void removeCategory(@PathParam("id") Long entityId) {
        categoryService.removeEntity(entityId);
    }

}
