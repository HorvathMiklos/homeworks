
package xyz.codingmentor.jpahw.service.crud;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahw.api.EntityModel;
import xyz.codingmentor.jpahw.api.gualifiers.Repo;
import xyz.codingmentor.jpahw.api.gualifiers.Specification;
import xyz.codingmentor.jpahw.api.interfaces.Repository;
import xyz.codingmentor.jpahw.api.interfaces.Service;
import xyz.codingmentor.jpahw.model.Entities.User;

/**
 *
 * @author mhorvath
 */
@Stateless
@Specification(EntityModel.USER)
public class UserService extends GeneralService<User> implements Service<User>{
    
    public UserService() {
        super(null);
    }
    public UserService(@Repo(EntityModel.USER) Repository<User> repository) {
        super(repository);
    }
}
