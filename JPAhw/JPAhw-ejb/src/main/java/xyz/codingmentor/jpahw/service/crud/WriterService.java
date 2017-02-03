
package xyz.codingmentor.jpahw.service.crud;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahw.api.EntityModel;
import xyz.codingmentor.jpahw.api.gualifiers.Repo;
import xyz.codingmentor.jpahw.api.gualifiers.Specification;
import xyz.codingmentor.jpahw.api.interfaces.Repository;
import xyz.codingmentor.jpahw.api.interfaces.Service;
import xyz.codingmentor.jpahw.model.Entities.Writer;

/**
 *
 * @author mhorvath
 */
@Stateless
@Specification(EntityModel.WRITER)
public class WriterService extends GeneralService<Writer> implements Service<Writer>{

    
    public WriterService() {
        super(null);
    }
    public WriterService(@Repo(EntityModel.WRITER) Repository<Writer> repository) {
        super(repository);
        
    }
}
