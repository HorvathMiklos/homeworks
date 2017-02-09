
package xyz.codingmentor;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.repo.MovieStarRepo;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("moviestar")
public class MoviestarResource {
    @Inject
    MovieStarRepo movieStarRepo;
    
    @Inject
    public MoviestarResource(MovieStarRepo movieStarRepo) {
        this.movieStarRepo = movieStarRepo;
    }

    

}
