
package xyz.codingmentor.jpahomework.service;

import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.BookDTO;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.api.WriterDTO;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.repo.BookRepo;
import xyz.codingmentor.jpahomework.repo.WriterRepo;

/**
 *
 * @author mhorvath
 */
public class WriterCRUDService {
    private WriterRepo writerRepo;
    
    @Inject 
    public WriterCRUDService(@RepoQualifyer(EntityType.WRITER) WriterRepo writerRepository) {
        this.writerRepo=writerRepository;
    }
    
    public WriterDTO createWriter(WriterDTO writerDTO) throws RepositoryException {
        return writerRepo.createWriter(writerDTO);
    }

    public WriterDTO findWriter(long id) throws RepositoryException {
        return writerRepo.findWriter(id);
    }

    public void updateWriter(WriterDTO writer) throws RepositoryException {
        writerRepo.updateWriter(writer);
    }

    public void removeWriter(long id) throws RepositoryException {
        writerRepo.removeWriter(id);
    }
}
