package xyz.codingmentor.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.model.MovieStar;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.model.Trailer;
import xyz.codingmentor.repo.JpqlRepo;

/**
 * @author mhorvath
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("jpql")
public class JpqlRESTResource {

    private final JpqlRepo jpqlService;

    @Inject
    public JpqlRESTResource(JpqlRepo jpqlService) {
        this.jpqlService = jpqlService;
    }

    @Path("moviestar/nation/{nt}")
    @GET
    public List<MovieStar> findMovieStarsByNation(@PathParam("nt") String nationality) {
        return jpqlService.findMovieStarsByNation(nationality);
    }

    @Path("trailer/{movie}")
    @GET
    public List<Trailer> findTrailersForMovie(@PathParam("movie") String movieTitle) {
        return jpqlService.findTrailersForMovie(movieTitle);
    }

    @Path("movie/")
    @GET
    public List<Movie> findMovieTitleCategory(@QueryParam("title") String title, @QueryParam("category") Long categoryId) {
        return jpqlService.findMovieTitleOrCategory(title, categoryId);
    }

    @Path("moviestar/")
    @GET
    public List<MovieStar> findMovieStarTitleName(@QueryParam("movie") String movie, @QueryParam("name") String movieStarName) {
        return jpqlService.findMovieStarTitleName(movie, movieStarName);
    }

}
