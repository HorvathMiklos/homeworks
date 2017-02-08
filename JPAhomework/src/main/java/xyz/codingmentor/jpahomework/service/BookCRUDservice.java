package xyz.codingmentor.jpahomework.service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.BookDTO;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;
import xyz.codingmentor.jpahomework.repo.BookRepo;

/**
 *
 * @author mhorvath
 */
public class BookCRUDservice {
    private BookRepo bookRepo;
    public BookCRUDservice() {
    }
    
    public BookDTO createBook(BookDTO bookDTO) throws RepositoryException {
        return bookRepo.createBook(bookDTO);
    }

    public BookDTO findBook(BookIdentifier bookIdentifier) throws RepositoryException {
        return bookRepo.findBook(bookIdentifier);
    }

    public void updateBook(BookDTO book) throws RepositoryException {
        bookRepo.updateBook(book);
    }

    public void removeBook(BookIdentifier bookIdentifier) throws RepositoryException {
        bookRepo.removeBook(bookIdentifier);
    }
}
