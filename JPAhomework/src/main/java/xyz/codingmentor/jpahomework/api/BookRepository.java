
package xyz.codingmentor.jpahomework.api;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;

/**
 *
 * @author mhorvath
 */
@Stateless
public interface BookRepository {
    BookDTO createBook(BookDTO book) throws RepositoryException;

    BookDTO findBook(String title) throws RepositoryException;

    BookDTO updateBook(BookDTO book) throws RepositoryException;

    BookDTO removeBook(String title) throws RepositoryException;

}
