
package xyz.codingmentor.jpahomework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.inject.Inject;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;
import xyz.codingmentor.jpahomework.model.entities.Book;
import xyz.codingmentor.jpahomework.model.entities.User;
import xyz.codingmentor.jpahomework.model.entities.Writer;
import xyz.codingmentor.jpahomework.model.enums.Gender;
import xyz.codingmentor.jpahomework.service.BookCRUDservice;
import xyz.codingmentor.jpahomework.service.JPQLservice;
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
    private final JPQLservice jpqlService;
    private static final Logger LOGGER=Logger.getLogger(Application.class.getName());

    @Inject
    public Application(WriterCRUDService writerCRUDService,
            UserCRUDservice userCRUDservice,
            BookCRUDservice bookCRUDservice,
            JPQLservice jpqlService) {
        this.writerCRUDService = writerCRUDService;
        this.userCRUDservice = userCRUDservice;
        this.bookCRUDservice = bookCRUDservice;
        this.jpqlService = jpqlService;
    }
    
    void execute() throws RepositoryException, ParseException {
                
        BookIdentifier bookIdentifierOne = new BookIdentifier("publisherOne", "BookOne");
        BookIdentifier bookIdentifierTwo = new BookIdentifier("publisherTwo", "BookTwo");
        BookIdentifier bookIdentifierThree = new BookIdentifier("publisherThree", "BookThree");
        BookIdentifier bookIdentifierFour = new BookIdentifier("publisherFour", "BookFour");
        BookIdentifier bookIdentifierFive = new BookIdentifier("publisherFive", "BookFive");
        BookIdentifier bookIdentifierSix = new BookIdentifier("publisherSix", "BookSix");
        BookIdentifier bookIdentifierScifi = new BookIdentifier("Scifi publisher", "Book scifi");
        
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
        Book bookSixModified = new Book();
        bookSixModified.setBookIdentifier(bookIdentifierSix);
        bookSixModified.setStyle("modified style");
        Book bookScifi = new Book();
        bookScifi.setBookIdentifier(bookIdentifierScifi);
        bookSixModified.setStyle("scifi");
        
        
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
        User longTimeUser= new User();
        userSix.setName("longTimeUser");
        User newUser= new User();
        userSix.setName("newUser");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1992 10:20:56";
        Date date = sdf.parse(dateInString);
        newUser.setDateOfRegistration(date);
        dateInString = "31-08-1942 10:20:56";
        date = sdf.parse(dateInString);
        longTimeUser.setDateOfRegistration(date);
        User manUser= new User();
        manUser.setName("man name");
        manUser.setGender(Gender.MAN);
        
        
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
        Writer Asimov =new Writer();
        Asimov.setName("Asimov");
        Writer youngWriter =new Writer();
        youngWriter.setName("young");
        dateInString = "31-08-1992 10:20:56";
        date = sdf.parse(dateInString);
        youngWriter.setDateOfBirth(date);
        Writer oldWriter =new Writer();
        oldWriter.setName("old");
        dateInString = "31-08-1942 10:20:56";
        date = sdf.parse(dateInString);
        oldWriter.setDateOfBirth(date);
        
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
        bookCRUDservice.createBook(bookScifi);
        //bookCRUDservice.close();
        
        userCRUDservice.createUser(userOne);
        userCRUDservice.createUser(userTwo);
        userCRUDservice.createUser(userThree);
        userCRUDservice.createUser(userFour);
        userCRUDservice.createUser(userFive);
        userCRUDservice.createUser(userSix);
        userCRUDservice.createUser(manUser);
        userCRUDservice.createUser(longTimeUser);
        userCRUDservice.createUser(newUser);
                
        writerCRUDService.createWriter(writerOne);
        writerCRUDService.createWriter(writerTwo);
        writerCRUDService.createWriter(writerThree);
        writerCRUDService.createWriter(writerFour);
        writerCRUDService.createWriter(writerFive);
        writerCRUDService.createWriter(writerSix);
        writerCRUDService.createWriter(oldWriter);
        writerCRUDService.createWriter(youngWriter);
        writerCRUDService.createWriter(Asimov);
        
        bookCRUDservice.removeBook(bookIdentifierFive);
        bookCRUDservice.updateBook(bookSixModified);
        LOGGER.log(Level.INFO, "find book "+bookCRUDservice.findBook(bookIdentifierSix).toString());
        bookCRUDservice.close();
        
        userCRUDservice.removeUser(userFive.getId());
        User userSixModified= new User();
        userSixModified.setId(userSix.getId());
        userSixModified.setGender(Gender.MAN);
        userCRUDservice.updateUser(userSixModified);
        LOGGER.log(Level.INFO, "find user "+userCRUDservice.findUser(userSix.getId()).toString());
        userCRUDservice.close();
        
        writerCRUDService.removeWriter(writerFive.getId());
        Writer writerSixModified =new Writer();
        writerSixModified.setId(writerSix.getId());
        writerSixModified.setGender(Gender.MAN);
        writerCRUDService.updateWriter(writerSixModified);
        LOGGER.log(Level.INFO, "find writer "+writerCRUDService.findWriter(writerSix.getId()).toString());
        writerCRUDService.close();
        
        dateInString = "31-08-1982 10:20:56";
        date = sdf.parse(dateInString);
        LOGGER.log(Level.INFO, "books where style is scifi "+jpqlService.listBooksByStyle("scifi").toString());
        LOGGER.log(Level.INFO, "male users: "+jpqlService.listUsersByGender(Gender.MAN).toString());
        LOGGER.log(Level.INFO, "longtime users:"+jpqlService.listUsersRegistratedBefore(date).toString());
        LOGGER.log(Level.INFO, "old writers"+jpqlService.listWritersBornBefore(date).toString());
        LOGGER.log(Level.INFO, "writer called Asimov"+jpqlService.listWritersByName("Asimov").toString());
    }

}
