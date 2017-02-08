
package xyz.codingmentor.jpahomework.api;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;

/**
 *
 * @author mhorvath
 */
@Stateless
public interface UserRepository {
    UserDTO createUser(UserDTO userDTO) throws RepositoryException;

    UserDTO findUser(Long id) throws RepositoryException;

    UserDTO updateUser(UserDTO userDTO) throws RepositoryException;

    UserDTO removeUser(Long id) throws RepositoryException;

    
}
