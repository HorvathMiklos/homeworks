
package xyz.codingmentor.jpahomework.repo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.api.BookRepository;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;
import xyz.codingmentor.jpahomework.model.entities.Book;

/**
 *
 * @author mhorvath
 */
@Stateless
@RepoQualifyer(EntityType.BOOK)
public class BookRepo implements BookRepository{
    
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public BookRepo() {
        factory = Persistence.createEntityManagerFactory("jpahomeworkpersistenceunit");
        entityManager = factory.createEntityManager();
    
    }
    
    @Override
    public Book createBook(Book book) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
        return book;
    }

    @Override
    public Book findBook(BookIdentifier bookIdentifier){
        return entityManager.find(Book.class, bookIdentifier);
        
    }

    @Override
    public Book updateBook(Book book) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(book);
        tx.commit();
        return findBook(book.getBookIdentifier());
    }

    @Override
    public Book removeBook(BookIdentifier bookIdentifier) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Book book = entityManager.find(Book.class, bookIdentifier);
        if (null != book) {
            entityManager.remove(book);
        }
        tx.commit();
        return book;
    }
    
    public List<Book> findBookByStyle(String style){
        Query query = entityManager.createNamedQuery("books.byStyle").setParameter("style",style);
        return query.getResultList();
    }
    
    public void close() {
        entityManager.close();
        factory.close();
    }

    
    

}
