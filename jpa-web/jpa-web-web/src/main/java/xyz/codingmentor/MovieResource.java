package xyz.codingmentor;

import javax.ws.rs.Path;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.api.CRUDServiceQualifier;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("movie")
public class MovieResource extends AbstractRestService<Movie> {

    @Inject
    public MovieResource(@CRUDServiceQualifier(EntityModel.MOVIE) CRUDService<Movie> crudService) {
        super(crudService);
    }
}
