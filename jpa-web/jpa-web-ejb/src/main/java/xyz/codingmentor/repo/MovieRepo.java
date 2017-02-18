package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDRepositoryQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;

/**
 * @author mhorvath
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.MOVIE)
public class MovieRepo extends AbstractCRUDRepository<Movie> implements CRUDRepository<Movie> {

    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }

}
