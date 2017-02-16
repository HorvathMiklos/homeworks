
package xyz.codingmentor.jpahomework.service;

import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.User;
import xyz.codingmentor.jpahomework.repo.UserRepo;

/**
 *
 * @author mhorvath
 */
public class UserCRUDservice { 
    private final UserRepo userRepo;
    
    @Inject 
    public UserCRUDservice(@RepoQualifyer(EntityType.USER) UserRepo userRepository) {
        this.userRepo=userRepository;
    }
    public User createUser(User user) throws RepositoryException {
        return userRepo.createUser(user);
    }

    public User findUser(long id) throws RepositoryException {
        return userRepo.findUser(id);
    }

    public void updateUser(User user) throws RepositoryException {
        userRepo.updateUser(user);
    }

    public void removeUser(long id) throws RepositoryException {
        userRepo.removeUser(id);
    }
    
    public void close(){
        userRepo.close();
    }
}
