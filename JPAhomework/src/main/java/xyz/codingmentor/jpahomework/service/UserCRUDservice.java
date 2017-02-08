
package xyz.codingmentor.jpahomework.service;

import xyz.codingmentor.jpahomework.api.BookDTO;
import xyz.codingmentor.jpahomework.api.UserDTO;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;
import xyz.codingmentor.jpahomework.repo.BookRepo;
import xyz.codingmentor.jpahomework.repo.UserRepo;

/**
 *
 * @author mhorvath
 */
public class UserCRUDservice { 
    private UserRepo userRepo;
    public UserCRUDservice() {
    }
    
    public UserDTO createUser(UserDTO userDTO) throws RepositoryException {
        return userRepo.createUser(userDTO);
    }

    public UserDTO findUser(long id) throws RepositoryException {
        return userRepo.findUser(id);
    }

    public void updateUser(UserDTO user) throws RepositoryException {
        userRepo.updateUser(user);
    }

    public void removeBook(long id) throws RepositoryException {
        userRepo.removeUser(id);
    }
}
