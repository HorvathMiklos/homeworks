package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;


/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDRepo(EntityModel.MOVIE)
public class MovieRepo extends AbstractCRUDRepository<Movie> implements CRUDRepository<Movie>{
    

    public MovieRepo() {
    }
    
    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }

    
    

    
}
