
package xyz.codingmentor.jpahomework.api;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.User;

/**
 *
 * @author mhorvath
 */
@Stateless
public interface UserRepository {
    User createUser(User user) throws RepositoryException;

    User findUser(Long id) throws RepositoryException;

    User updateUser(User user) throws RepositoryException;

    User removeUser(Long id) throws RepositoryException;
    
}
