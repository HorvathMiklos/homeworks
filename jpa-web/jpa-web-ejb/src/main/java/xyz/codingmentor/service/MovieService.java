
package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecification;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDSpecification(EntityModel.MOVIE)
public class MovieService extends AbstractCRUDService<Movie> implements CRUDService<Movie>{
    public MovieService() {
        super(null);
    }
    
    @Inject
    public MovieService(@CRUDRepo(EntityModel.MOVIE) CRUDRepository<Movie> repository) {
        super(repository);
    }
    
}
