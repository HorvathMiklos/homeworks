
package xyz.codingmentor.jpahomework.service;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.model.entities.Book;
import xyz.codingmentor.jpahomework.model.entities.User;
import xyz.codingmentor.jpahomework.model.entities.Writer;
import xyz.codingmentor.jpahomework.model.enums.Gender;
import xyz.codingmentor.jpahomework.repo.BookRepo;
import xyz.codingmentor.jpahomework.repo.UserRepo;
import xyz.codingmentor.jpahomework.repo.WriterRepo;

/**
 *
 * @author mhorvath
 */
@Stateless
public class JPQLservice {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    private WriterRepo writerRepo;
    @Inject
    public JPQLservice(@RepoQualifyer(EntityType.BOOK) BookRepo bookRepository,
            @RepoQualifyer(EntityType.USER) UserRepo userRepository,
            @RepoQualifyer(EntityType.WRITER) WriterRepo writerRepository) {
        this.bookRepo=bookRepository;
        this.userRepo=userRepository;
        this.writerRepo=writerRepository;
    }
    public List<Writer> listWritersByName(String name){
        return writerRepo.findWriterByName(name);
    }
    public List<Writer> listWritersBornBefore(Date date){
        return writerRepo.writersBornBefore(date);
    }
    public List<User> listUsersByGender(Gender gender){
        return userRepo.userByGender(gender);
    }
    public List<User> listUsersRegistratedBefore(Date date){
        return userRepo.usersRegisteredBefore(date);
    }    
    public List<Book> listBooksByStyle(String style){
        return bookRepo.findBookByStyle(style);
    }
}
