
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
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecification;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.MovieStar;
import xyz.codingmentor.repo.MovieStarRepo;
import xyz.codingmentor.service.MovieStarService;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("moviestar")
public class MoviestarResource {
    
    private final CRUDService<MovieStar> movieStarService;
    
    @Inject
    public MoviestarResource(@CRUDSpecification(EntityModel.MOVIESTAR) CRUDService<MovieStar>  movieStarService) {
        this.movieStarService=movieStarService;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMovieStar(MovieStar movieStar){
        movieStarService.createEntity(movieStar);
    }
    
    @GET
    @Path("/{id}")
    public MovieStar getMovieStarById(@PathParam("id") Long entityId){
        return movieStarService.getEntityById(entityId);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public MovieStar updateMovieStar(MovieStar movieStar){
        return movieStarService.updateEntity(movieStar);
    }
    
    @DELETE
    @Path("/{id}")
    public void removeMovieStar(@PathParam("id") Long entityId){
        movieStarService.removeEntity(entityId);
    }
    @GET
    @Path("/getexample")
    public MovieStar getMovieStarExample(){
        MovieStar movieStar= new MovieStar();
        movieStar.setFirstName("movistarfirstname");
        movieStar.setLastName("movistarlastname");
        movieStar.setNationality("Hungarian");
        return movieStar;
    }
    
}
