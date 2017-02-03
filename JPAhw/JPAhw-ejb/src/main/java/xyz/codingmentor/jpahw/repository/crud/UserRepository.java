package xyz.codingmentor.jpahw.repository.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpahw.api.EntityModel;
import xyz.codingmentor.jpahw.api.gualifiers.Repo;
import xyz.codingmentor.jpahw.api.interfaces.Repository;
import xyz.codingmentor.jpahw.model.Entities.User;

/**
 *
 * @author mhorvath
 */
@Stateless
@Repo(EntityModel.USER)
public class UserRepository extends AbstractRepository<User> implements Repository<User> {
    @PersistenceContext(unitName = "JPAHomeWorkPersistenceContext")
    private EntityManager entityManager;
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
