
package xyz.codingmentor.jpahw.repository.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpahw.api.EntityModel;
import xyz.codingmentor.jpahw.api.gualifiers.Repo;
import xyz.codingmentor.jpahw.api.interfaces.Repository;
import xyz.codingmentor.jpahw.model.Entities.Book;

/**
 *
 * @author mhorvath
 */
@Stateless
@Repo(EntityModel.BOOK)
public class BookRepository extends AbstractRepository<Book> implements Repository<Book>{
    @PersistenceContext(unitName = "JPAHomeWorkPersistenceContext")
    private EntityManager entityManager;

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
