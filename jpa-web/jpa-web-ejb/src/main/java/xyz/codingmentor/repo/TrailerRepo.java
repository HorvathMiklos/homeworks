
package xyz.codingmentor.repo;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDRepo(EntityModel.TRAILER)
public class TrailerRepo extends AbstractCRUDRepository<Trailer> implements CRUDRepository<Trailer>{

    public TrailerRepo() {
    }

    @Override
    protected Class<Trailer> getEntityClass() {
        return Trailer.class;
    }
    
}
