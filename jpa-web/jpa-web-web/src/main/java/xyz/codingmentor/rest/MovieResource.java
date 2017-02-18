package xyz.codingmentor.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;

/**
 * @author mhorvath
 */
@Path("movie")
public class MovieResource extends GenericRESTService<Movie> {

    @Inject
    public MovieResource(@CRUDServiceQualifier(EntityModel.MOVIE) CRUDService<Movie> crudService) {
        super(crudService);
    }
}
