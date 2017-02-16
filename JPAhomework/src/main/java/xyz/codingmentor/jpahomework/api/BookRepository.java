
package xyz.codingmentor.jpahomework.api;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;
import xyz.codingmentor.jpahomework.model.entities.Book;

/**
 *
 * @author mhorvath
 */
@Stateless
public interface BookRepository {
    Book createBook(Book book) throws RepositoryException;

    Book findBook(BookIdentifier bookIdentifier) throws RepositoryException;

    Book updateBook(Book book) throws RepositoryException;

    Book removeBook(BookIdentifier bookIdentifie) throws RepositoryException;

}
