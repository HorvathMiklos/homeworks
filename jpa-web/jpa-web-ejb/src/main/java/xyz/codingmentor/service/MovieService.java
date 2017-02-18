package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDRepositoryQualifier;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;

/**
 * @author mhorvath
 */
@Stateless
@CRUDServiceQualifier(EntityModel.MOVIE)
public class MovieService extends GenericCRUDService<Movie> implements CRUDService<Movie>{

    public MovieService() {
        super(null);
    }

    @Inject
    public MovieService(@CRUDRepositoryQualifier(EntityModel.MOVIE) CRUDRepository<Movie> repository) {
        super(repository);
    }
}
