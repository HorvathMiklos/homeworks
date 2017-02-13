
package xyz.codingmentor.jpahomework.service;

import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.BookDTO;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.api.UserDTO;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.repo.BookRepo;
import xyz.codingmentor.jpahomework.repo.UserRepo;
import xyz.codingmentor.jpahomework.repo.WriterRepo;

/**
 *
 * @author mhorvath
 */
public class UserCRUDservice { 
    private UserRepo userRepo;
    
    @Inject 
    public UserCRUDservice(@RepoQualifyer(EntityType.USER) UserRepo userRepository) {
        this.userRepo=userRepository;
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
