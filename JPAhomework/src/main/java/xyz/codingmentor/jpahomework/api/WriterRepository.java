
package xyz.codingmentor.jpahomework.api;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.Writer;

/**
 *
 * @author mhorvath
 */
@Stateless
public interface WriterRepository {
    Writer createWriter(Writer writer) throws RepositoryException;

    Writer findWriter(Long id) throws RepositoryException;

    Writer updateWriter(Writer writer) throws RepositoryException;

    Writer removeWriter(Long id) throws RepositoryException;

   
}
