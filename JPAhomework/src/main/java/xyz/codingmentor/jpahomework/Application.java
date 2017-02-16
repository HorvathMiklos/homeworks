
package xyz.codingmentor.jpahomework;

import javax.ejb.Singleton;
import javax.inject.Inject;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;
import xyz.codingmentor.jpahomework.model.entities.Book;
import xyz.codingmentor.jpahomework.model.entities.User;
import xyz.codingmentor.jpahomework.model.entities.Writer;
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
                
        BookIdentifier bookIdentifierOne = new BookIdentifier("publisherOne", "BookOne");
        BookIdentifier bookIdentifierTwo = new BookIdentifier("publisherTwo", "BookTwo");
        BookIdentifier bookIdentifierThree = new BookIdentifier("publisherThree", "BookThree");
        BookIdentifier bookIdentifierFour = new BookIdentifier("publisherFour", "BookFour");
        BookIdentifier bookIdentifierFive = new BookIdentifier("publisherFive", "BookFive");
        BookIdentifier bookIdentifierSix = new BookIdentifier("publisherSix", "BookSix");
        
        Book bookOne = new Book();
        bookOne.setBookIdentifier(bookIdentifierOne);
        Book bookTwo = new Book();
        bookTwo.setBookIdentifier(bookIdentifierTwo);
        Book bookThree = new Book();
        bookThree.setBookIdentifier(bookIdentifierThree);
        Book bookFour = new Book();
        bookFour.setBookIdentifier(bookIdentifierFour);
        Book bookFive = new Book();
        bookFive.setBookIdentifier(bookIdentifierFive);
        Book bookSix = new Book();
        bookSix.setBookIdentifier(bookIdentifierSix);
        
        User userOne= new User();
        userOne.setName("userOne");
        User userTwo= new User();
        userTwo.setName("userTwo");
        User userThree= new User();
        userThree.setName("userThree");
        User userFour= new User();
        userFour.setName("userFour");
        User userFive= new User();
        userFive.setName("userFive");
        User userSix= new User();
        userSix.setName("userSix");
        
        Writer writerOne=new Writer();
        writerOne.setName("writerOne");
        Writer writerTwo=new Writer();
        writerTwo.setName("writerTwo");
        Writer writerThree=new Writer();
        writerThree.setName("writerThree");
        Writer writerFour =new Writer();
        writerFour.setName("writerFour");
        Writer writerFive =new Writer();
        writerFive.setName("writerFive");
        Writer writerSix =new Writer();
        writerSix.setName("writerSix");
        
        userFour.rentBook(bookFour);
        userOne.rentBook(bookOne);        
        userThree.rentBook(bookThree);
        
        
        writerOne.addWritenBook(bookTwo);
        
        writerTwo.addWritenBook(bookOne);
        
        writerThree.addWritenBook(bookThree);
        
        writerFour.addWritenBook(bookFour);
        
        bookCRUDservice.createBook(bookOne);
        bookCRUDservice.createBook(bookTwo);
        bookCRUDservice.createBook(bookThree);
        bookCRUDservice.createBook(bookFour);
        bookCRUDservice.createBook(bookFive);
        bookCRUDservice.createBook(bookSix);
        bookCRUDservice.close();
        
        userCRUDservice.createUser(userOne);
        userCRUDservice.createUser(userTwo);
        userCRUDservice.createUser(userThree);
        userCRUDservice.createUser(userFour);
        userCRUDservice.createUser(userFive);
        userCRUDservice.createUser(userSix);
        userCRUDservice.close();      
                
        writerCRUDService.createWriter(writerOne);
        writerCRUDService.createWriter(writerTwo);
        writerCRUDService.createWriter(writerThree);
        writerCRUDService.createWriter(writerFour);
        writerCRUDService.createWriter(writerFive);
        writerCRUDService.createWriter(writerSix);
        writerCRUDService.close();
 
    }

}
