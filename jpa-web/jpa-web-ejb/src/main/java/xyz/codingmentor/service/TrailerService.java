
package xyz.codingmentor.service;

import javax.ejb.Stateless;
import xyz.codingmentor.api.CRUDRepo;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecification;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 *
 * @author mhorvath
 */
@Stateless
@CRUDSpecification(EntityModel.TRAILER)
public class TrailerService extends AbstractCRUDService<Trailer> implements CRUDService<Trailer>{
    
    public TrailerService() {
        super(null);
    }
    
    public TrailerService(@CRUDRepo(EntityModel.TRAILER) CRUDRepository<Trailer> repository) {
        super(repository);
    }

}
