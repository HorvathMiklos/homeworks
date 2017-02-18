package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.model.MovieStar;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDRepositoryQualifier;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;

/**
 * @author mhorvath
 */
@Stateless
@CRUDServiceQualifier(EntityModel.MOVIESTAR)
public class MovieStarService extends GenericCRUDService<MovieStar> implements CRUDService<MovieStar> {

    public MovieStarService() {
        super(null);
    }

    @Inject
    public MovieStarService(@CRUDRepositoryQualifier(EntityModel.MOVIESTAR) CRUDRepository<MovieStar> repository) {
        super(repository);
    }
}
