package xyz.codingmentor.jpahomework.service;

import javax.inject.Inject;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;
import xyz.codingmentor.jpahomework.model.entities.Book;
import xyz.codingmentor.jpahomework.repo.BookRepo;

/**
 *
 * @author mhorvath
 */
public class BookCRUDservice {
    private final BookRepo bookRepo;
    
    @Inject
    public BookCRUDservice(@RepoQualifyer(EntityType.BOOK) BookRepo bookRepository) {
        this.bookRepo=bookRepository;
    }
    
    public Book createBook(Book book) throws RepositoryException {
        return bookRepo.createBook(book);
    }

    public Book findBook(BookIdentifier bookIdentifier) throws RepositoryException {
        return bookRepo.findBook(bookIdentifier);
    }

    public void updateBook(Book book) throws RepositoryException {
        bookRepo.updateBook(book);
    }

    public void removeBook(String title) throws RepositoryException {
        bookRepo.removeBook(title);
    }
    public void close(){
        bookRepo.close();
    }
}
