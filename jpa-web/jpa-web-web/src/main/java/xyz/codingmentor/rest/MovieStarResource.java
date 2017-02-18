package xyz.codingmentor.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.MovieStar;

/**
 * @author mhorvath
 */
@Path("movieStar")
public class MovieStarResource extends GenericRESTService<MovieStar> {

    @Inject
    public MovieStarResource(@CRUDServiceQualifier(EntityModel.MOVIESTAR) CRUDService<MovieStar> crudService) {
        super(crudService);
    }
}
