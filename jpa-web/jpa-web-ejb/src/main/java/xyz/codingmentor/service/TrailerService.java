package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;
import xyz.codingmentor.api.CRUDRepoQualifier;
import xyz.codingmentor.api.CRUDServiceQualifier;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDServiceQualifier(EntityModel.TRAILER)
public class TrailerService extends AbstractCRUDService<Trailer> implements CRUDService<Trailer> {

    public TrailerService() {
        super(null);
    }

    @Inject
    public TrailerService(@CRUDRepoQualifier(EntityModel.TRAILER) CRUDRepository<Trailer> repository) {
        super(repository);
    }

}
