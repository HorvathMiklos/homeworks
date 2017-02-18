package xyz.codingmentor;

import javax.ws.rs.Path;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("trailer")
public class TrailerResource extends AbstractRestService<Trailer> {

    @Inject
    public TrailerResource(@CRUDServiceQualifier(EntityModel.TRAILER) CRUDService<Trailer> crudService) {
        super(crudService);
    }
}
