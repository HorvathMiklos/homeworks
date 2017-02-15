
package xyz.codingmentor.jpahomework.service;

import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.Writer;
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
    
    public Writer createWriter(Writer writer) throws RepositoryException {
        return writerRepo.createWriter(writer);
    }

    public Writer findWriter(long id) throws RepositoryException {
        return writerRepo.findWriter(id);
    }

    public void updateWriter(Writer writer) throws RepositoryException {
        writerRepo.updateWriter(writer);
    }

    public void removeWriter(long id) throws RepositoryException {
        writerRepo.removeWriter(id);
    }
    public void close(){
        writerRepo.close();
    }
}
