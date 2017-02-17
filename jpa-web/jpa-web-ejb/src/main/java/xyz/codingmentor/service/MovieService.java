package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.api.CRUDRepoQualifier;
import xyz.codingmentor.api.CRUDServiceQualifier;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDServiceQualifier(EntityModel.MOVIE)
public class MovieService extends AbstractCRUDService<Movie> implements CRUDService<Movie> {

    public MovieService() {
        super(null);
    }

    @Inject
    public MovieService(@CRUDRepoQualifier(EntityModel.MOVIE) CRUDRepository<Movie> repository) {
        super(repository);
    }

}
