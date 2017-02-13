
package xyz.codingmentor.jpahomework;

import javax.ejb.Singleton;
import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.BookDTO;
import xyz.codingmentor.jpahomework.api.UserDTO;
import xyz.codingmentor.jpahomework.api.WriterDTO;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.enums.Gender;
import xyz.codingmentor.jpahomework.repo.WriterRepo;
import xyz.codingmentor.jpahomework.service.BookCRUDservice;
import xyz.codingmentor.jpahomework.service.UserCRUDservice;
import xyz.codingmentor.jpahomework.service.WriterCRUDService;

/**
 *
 * @author mhorvath
 */
@Singleton
public class Application {
    
    private final WriterCRUDService writerCRUDService;
    private final UserCRUDservice userCRUDservice;
    private final BookCRUDservice bookCRUDservice;

    @Inject
    public Application(WriterCRUDService writerCRUDService,UserCRUDservice userCRUDservice,BookCRUDservice bookCRUDservice) {
        this.writerCRUDService = writerCRUDService;
        this.userCRUDservice = userCRUDservice;
        this.bookCRUDservice = bookCRUDservice;
    }
    
    void execute() throws RepositoryException {
        WriterDTO testWriter=new WriterDTO();
        testWriter.setName("Béla");
        testWriter.setGender(Gender.MAN);
        writerCRUDService.createWriter(testWriter);
        
        UserDTO testUser= new UserDTO();
        testUser.setName("username");
        userCRUDservice.createUser(testUser);
        
        BookDTO testBook = new BookDTO();
        testBook.setTitle("testBook title");
        bookCRUDservice.createBook(testBook);
        
        BookDTO bookOne = new BookDTO();
        testBook.setTitle("bookOne");
        BookDTO bookTwo = new BookDTO();
        testBook.setTitle("bookTwo");
        BookDTO bookThree = new BookDTO();
        testBook.setTitle("bookThree");
        BookDTO bookFour = new BookDTO();
        testBook.setTitle("bookFour");       
        
        UserDTO userOne= new UserDTO();
        testUser.setName("userOne");
        UserDTO userTwo= new UserDTO();
        testUser.setName("userTwo");
        UserDTO userThree= new UserDTO();
        testUser.setName("userThree");
        UserDTO userFour= new UserDTO();
        testUser.setName("userFour");
        
        WriterDTO writerOne=new WriterDTO();
        testWriter.setName("writerOne");
        WriterDTO writerTwo=new WriterDTO();
        testWriter.setName("writerTwo");
        WriterDTO writerThree=new WriterDTO();
        testWriter.setName("writerThree");
        WriterDTO writerFour =new WriterDTO();
        testWriter.setName("writerFour");
        
        userOne.addRentedBook(bookOne);
        userOne.addRentedBook(bookTwo);
        userOne.addRentedBook(bookThree);
        userOne.addRentedBook(bookFour);
        userTwo.addRentedBook(bookTwo);
    }

}
