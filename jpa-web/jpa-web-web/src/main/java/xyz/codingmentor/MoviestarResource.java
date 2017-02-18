package xyz.codingmentor;

import javax.ws.rs.Path;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.MovieStar;
import xyz.codingmentor.api.CRUDServiceQualifier;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("moviestar")
public class MoviestarResource extends AbstractRestService<MovieStar> {

    @Inject
    public MoviestarResource(@CRUDServiceQualifier(EntityModel.MOVIESTAR) CRUDService<MovieStar> crudService) {
        super(crudService);
    }
}
