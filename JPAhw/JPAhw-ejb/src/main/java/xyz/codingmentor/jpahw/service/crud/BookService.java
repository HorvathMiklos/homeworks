
package xyz.codingmentor.jpahw.service.crud;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpahw.api.EntityModel;
import xyz.codingmentor.jpahw.api.gualifiers.Repo;
import xyz.codingmentor.jpahw.api.gualifiers.Specification;
import xyz.codingmentor.jpahw.api.interfaces.Repository;
import xyz.codingmentor.jpahw.api.interfaces.Service;
import xyz.codingmentor.jpahw.model.Entities.Book;

/**
 *
 * @author mhorvath
 */
@Stateless
@Specification(EntityModel.BOOK)
public class BookService extends GeneralService<Book> implements Service<Book>{

    public BookService() {
        super(null);
    }
    
    @Inject
    public BookService(@Repo(EntityModel.BOOK) Repository<Book> repository) {
        super(repository);
    }
    
}
