package xyz.codingmentor.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 * @author mhorvath
 */
@Path("trailer")
public class TrailerResource extends GenericRESTService<Trailer> {

    @Inject
    public TrailerResource(@CRUDServiceQualifier(EntityModel.TRAILER) CRUDService<Trailer> crudService) {
        super(crudService);
    }
}
