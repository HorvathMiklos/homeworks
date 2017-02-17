package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.MovieStar;
import xyz.codingmentor.api.CRUDRepoQualifier;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDRepoQualifier(EntityModel.MOVIESTAR)
public class MovieStarRepo extends AbstractCRUDRepository<MovieStar> implements CRUDRepository<MovieStar> {

    @Override
    protected Class<MovieStar> getEntityClass() {
        return MovieStar.class;
    }

}
