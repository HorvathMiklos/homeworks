
package xyz.codingmentor.jpahomework.repo;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.api.UserRepository;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.User;
import xyz.codingmentor.jpahomework.model.enums.Gender;

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
    
    public List<User> userByGender(Gender gender){
        Query query = entityManager.createNamedQuery("my_user.byGender").setParameter("gender",gender);
        return query.getResultList();
    }
    
    public List<User> usersRegisteredBefore(Date date){
        Query query = entityManager.createNamedQuery("my_user.registrationBefore").setParameter("date",date);
        return query.getResultList();
    }

    public void close(){
        entityManager.close();
        factory.close();
    }
    
}
