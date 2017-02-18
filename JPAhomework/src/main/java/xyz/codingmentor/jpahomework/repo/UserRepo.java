
package xyz.codingmentor.jpahomework.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpahomework.api.UserDTO;
import xyz.codingmentor.jpahomework.api.UserRepository;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.User;

/**
 *
 * @author mhorvath
 */
@Stateless
public class UserRepo implements UserRepository{
    @PersistenceContext(unitName = "jpahomeworkpersistenceunit")
    private EntityManager entityManager;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws RepositoryException {
        User user = new User(userDTO);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(user);
        tx.commit();
        return buildUser(user);
    }

    @Override
    public UserDTO findUser(Long id) throws RepositoryException {
        User user = entityManager.find(User.class, id);
        if (null != user) {
            return buildUser(user);
        }
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO user) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        User entity = entityManager.find(User.class, user.getId());
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setGender(user.getGender());
        entity.setAddress(user.getAddress());
        entity.setRentedBooks(user.getRentedBooks());
        entity.setDateOfRegistration(user.getDateOfRegistration());
        entity.setDateOfBirth(user.getDateOfBirth());
        entityManager.merge(entity);
        tx.commit();
        return buildUser(entity);
    }

    @Override
    public UserDTO removeUser(Long id) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        User user = entityManager.find(User.class, id);
        if (null != user) {
            entityManager.remove(user);
        }
        tx.commit();
        return buildUser(user);
    }

    private UserDTO buildUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setGender(user.getGender());
        userDTO.setAddress(user.getAddress());
        userDTO.setRentedBooks(user.getRentedBooks());
        userDTO.setDateOfRegistration(user.getDateOfRegistration());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        return userDTO;
    }
}
