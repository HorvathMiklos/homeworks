package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.model.Trailer;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDRepositoryQualifier;
import xyz.codingmentor.api.EntityModel;

/**
 * @author mhorvath
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.TRAILER)
public class TrailerRepo extends AbstractCRUDRepository<Trailer> implements CRUDRepository<Trailer> {

    @Override
    protected Class<Trailer> getEntityClass() {
        return Trailer.class;
    }

}
