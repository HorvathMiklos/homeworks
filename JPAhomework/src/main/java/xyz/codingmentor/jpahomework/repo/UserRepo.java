
package xyz.codingmentor.jpahomework.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.api.UserRepository;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.User;

/**
 *
 * @author mhorvath
 */
@Stateless
@RepoQualifyer(EntityType.USER)
public class UserRepo implements UserRepository{
   
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    
    public UserRepo() {
        factory = Persistence.createEntityManagerFactory("jpahomeworkpersistenceunit");
        entityManager = factory.createEntityManager();
    
    }
    @Override
    public User createUser(User user) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(user);
        tx.commit();
        return user;
    }

    @Override
    public User findUser(Long id) throws RepositoryException {
        User user = entityManager.find(User.class, id);
        if (null != user) {
            return user;
        }
        return null;
    }

    @Override
    public User updateUser(User user) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        //User entity = entityManager.find(User.class, user.getId());
        entityManager.merge(user);
        tx.commit();
        return user;
    }

    @Override
    public User removeUser(Long id) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        User user = entityManager.find(User.class, id);
        if (null != user) {
            entityManager.remove(user);
        }
        tx.commit();
        return user;
    }

    public void close(){
        entityManager.close();
        factory.close();
    }
    
}
