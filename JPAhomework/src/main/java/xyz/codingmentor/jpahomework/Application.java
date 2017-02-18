
package xyz.codingmentor.jpahomework;

import javax.ejb.Singleton;
import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.WriterDTO;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.enums.Gender;
import xyz.codingmentor.jpahomework.repo.WriterRepo;
import xyz.codingmentor.jpahomework.service.WriterCRUDService;

/**
 *
 * @author mhorvath
 */
@Singleton
public class Application {
    
    private final WriterCRUDService writerCRUDService;

    @Inject
    public Application(WriterCRUDService writerCRUDService) {
        this.writerCRUDService = writerCRUDService;
    }
    
    
    void execute() throws RepositoryException {
        WriterDTO testWriter=new WriterDTO();
        testWriter.setName("Béla");
        testWriter.setGender(Gender.MAN);
        writerCRUDService.createWriter(testWriter);
    }

}
