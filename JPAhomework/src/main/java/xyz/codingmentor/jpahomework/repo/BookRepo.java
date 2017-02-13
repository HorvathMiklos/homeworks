
package xyz.codingmentor.jpahomework.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpahomework.api.BookDTO;
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
    public BookDTO createBook(BookDTO bookdto) throws RepositoryException {
        Book book = new Book(bookdto);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
        return buildBook(book);
    }

    @Override
    public BookDTO findBook(String title) throws RepositoryException {
        Book book = entityManager.find(Book.class, title);
        if (null != book) {
            return buildBook(book);
        }
        return null;
    }

    @Override
    public BookDTO updateBook(BookDTO book) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Book entity = entityManager.find(Book.class, book.getTitle());
        entity.setTitle(book.getTitle());
        entity.setStyle(book.getStyle());
        entityManager.merge(entity);
        tx.commit();
        return buildBook(entity);
    }

    @Override
    public BookDTO removeBook(String title) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Book book = entityManager.find(Book.class, title);
        if (null != book) {
            entityManager.remove(book);
        }
        tx.commit();
        return buildBook(book);
    }
/*
    @Override
    public void close() {
        
    }
*/
    private BookDTO buildBook(Book book) {
        BookDTO bookDTO=new BookDTO();
        bookDTO.setTitle(book.getTitle());
        bookDTO.setStyle(book.getStyle());
        return bookDTO;
    }
    

}
