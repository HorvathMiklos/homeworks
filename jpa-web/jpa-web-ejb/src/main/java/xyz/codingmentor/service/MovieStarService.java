
package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecification;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.MovieStar;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDSpecification(EntityModel.MOVIESTAR)
public class MovieStarService extends AbstractCRUDService<MovieStar> implements CRUDService<MovieStar>{

    public MovieStarService() {
        super(null);
    }
    
    @Inject
    public MovieStarService(@CRUDRepo(EntityModel.MOVIESTAR) CRUDRepository<MovieStar> repository) {
        super(repository);
    }
    
}
