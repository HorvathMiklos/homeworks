package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.api.CRUDRepoQualifier;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDRepoQualifier(EntityModel.MOVIE)
public class MovieRepo extends AbstractCRUDRepository<Movie> implements CRUDRepository<Movie> {

    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }

}
