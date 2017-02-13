package xyz.codingmentor.jpahomework.service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.BookDTO;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.repo.BookRepo;
import xyz.codingmentor.jpahomework.repo.WriterRepo;

/**
 *
 * @author mhorvath
 */
public class BookCRUDservice {
    private BookRepo bookRepo;
    
    @Inject
    public BookCRUDservice(@RepoQualifyer(EntityType.BOOK) BookRepo bookRepository) {
        this.bookRepo=bookRepository;
    }
    
    public BookDTO createBook(BookDTO bookDTO) throws RepositoryException {
        return bookRepo.createBook(bookDTO);
    }

    public BookDTO findBook(String title) throws RepositoryException {
        return bookRepo.findBook(title);
    }

    public void updateBook(BookDTO book) throws RepositoryException {
        bookRepo.updateBook(book);
    }

    public void removeBook(String title) throws RepositoryException {
        bookRepo.removeBook(title);
    }
}
