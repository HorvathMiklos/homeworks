
package xyz.codingmentor.jpahomework.api;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;

/**
 *
 * @author mhorvath
 */
@Stateless
public interface BookRepository {
    BookDTO createBook(BookDTO book) throws RepositoryException;

    BookDTO findBook(BookIdentifier bookIdentifier) throws RepositoryException;

    BookDTO updateBook(BookDTO book) throws RepositoryException;

    BookDTO removeBook(BookIdentifier bookIdentifier) throws RepositoryException;

}
