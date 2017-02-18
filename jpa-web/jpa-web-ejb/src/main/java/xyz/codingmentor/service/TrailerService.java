package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.model.Trailer;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDRepositoryQualifier;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDServiceQualifier;
import xyz.codingmentor.api.EntityModel;


/**
 * @author mhorvath
 */
@Stateless
@CRUDServiceQualifier(EntityModel.TRAILER)
public class TrailerService extends GenericCRUDService<Trailer> implements CRUDService<Trailer> {

    public TrailerService() {
        super(null);
    }

    @Inject
    public TrailerService(@CRUDRepositoryQualifier(EntityModel.TRAILER) CRUDRepository<Trailer> repository) {
        super(repository);
    }
}