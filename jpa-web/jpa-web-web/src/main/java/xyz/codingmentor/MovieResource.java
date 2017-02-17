package xyz.codingmentor;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
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
public class MovieResource {

    private final CRUDService<Movie> movieService;

    @Inject
    public MovieResource(@CRUDServiceQualifier(EntityModel.MOVIE) CRUDService<Movie> movieService) {
        this.movieService = movieService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMovie(Movie movie) {
        movieService.createEntity(movie);
    }

    @GET
    @Path("/{id}")
    public Movie getMovieById(@PathParam("id") Long movieId) {
        return movieService.getEntityById(movieId);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Movie updateMovie(Movie movie) {
        return movieService.updateEntity(movie);
    }

    @POST
    @Path("/delete/{id}")
    public void removeMovie(@PathParam("id") Long movieId) {
        movieService.removeEntity(movieId);
    }

}
