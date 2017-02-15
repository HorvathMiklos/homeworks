
package xyz.codingmentor.jpahomework.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.api.BookRepository;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.model.entities.Book;

/**
 *
 * @author mhorvath
 */
@Stateless
@RepoQualifyer(EntityType.BOOK)
public class BookRepo implements BookRepository{
    /*
    @PersistenceContext(unitName = "jpahomeworkpersistenceunit")
    private EntityManager entityManager;
    */
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
    public Book findBook(String title){
        return entityManager.find(Book.class, title);
        
    }

    @Override
    public Book updateBook(Book book) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Book entity = entityManager.find(Book.class, book.getBookIdentifier());
        entity.setBookIdentifier(book.getBookIdentifier());
        entity.setStyle(book.getStyle());
        entityManager.merge(entity);
        tx.commit();
        return entity;
    }

    @Override
    public Book removeBook(String title) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Book book = entityManager.find(Book.class, title);
        if (null != book) {
            entityManager.remove(book);
        }
        tx.commit();
        return book;
    }

    public void close() {
        entityManager.close();
        factory.close();
    }

    
    

}
