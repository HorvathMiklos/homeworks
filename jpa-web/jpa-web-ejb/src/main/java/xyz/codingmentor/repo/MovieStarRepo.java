
package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.MovieStar;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDRepo(EntityModel.MOVIESTAR)
public class MovieStarRepo extends AbstractCRUDRepository<MovieStar> implements CRUDRepository<MovieStar>{

    public MovieStarRepo() {
    }
    
    @Override
    protected Class<MovieStar> getEntityClass() {
        return MovieStar.class;
    }
    
}
