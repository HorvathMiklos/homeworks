
package xyz.codingmentor.jpahomework.api;

import javax.ejb.Stateless;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;

/**
 *
 * @author mhorvath
 */
@Stateless
public interface WriterRepository {
    WriterDTO createWriter(WriterDTO writerDTO) throws RepositoryException;

    WriterDTO findWriter(Long id) throws RepositoryException;

    WriterDTO updateWriter(WriterDTO writerDTO) throws RepositoryException;

    WriterDTO removeWriter(Long id) throws RepositoryException;

   
}
