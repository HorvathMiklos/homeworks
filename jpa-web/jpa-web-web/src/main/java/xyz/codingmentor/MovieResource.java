
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
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.repo.MovieRepo;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("movie")
@RequestScoped
public class MovieResource {
    CRUDRepository<Movie> movieRepo;
    @Inject
    public MovieResource(@CRUDRepo(EntityModel.MOVIE) CRUDRepository<Movie> movieRepo) {
        this.movieRepo = movieRepo;
    }

    public MovieResource() {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void Test(Movie movie) {
        movieRepo.persist(movie);
    }

    
}
