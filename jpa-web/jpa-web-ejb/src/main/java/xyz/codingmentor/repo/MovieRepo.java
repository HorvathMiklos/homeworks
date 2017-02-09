package xyz.codingmentor.repo;

import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.model.MovieStar;


/**
 *
 * @author mhorvath
 */
@Stateless
public class MovieRepo extends AbstractCRUDRepository<Movie> implements CRUDRepository<Movie>{
    @PersistenceContext(unitName = "jpawebPU")
    private EntityManager entityManager;

    
    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    
}
