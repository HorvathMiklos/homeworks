
package xyz.codingmentor.jpahw.repository.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpahw.api.EntityModel;
import xyz.codingmentor.jpahw.api.gualifiers.Repo;
import xyz.codingmentor.jpahw.api.interfaces.Repository;
import xyz.codingmentor.jpahw.model.Entities.Book;
import xyz.codingmentor.jpahw.model.Entities.Writer;

/**
 *
 * @author mhorvath
 */
@Stateless
@Repo(EntityModel.WRITER)
public class WriterRepository extends AbstractRepository<Writer> implements Repository<Writer>{
    @PersistenceContext(unitName = "JPAHomeWorkPersistenceContext")
    private EntityManager entityManager;

    @Override
    protected Class<Writer> getEntityClass() {
        return Writer.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
