
package xyz.codingmentor.jpahomework.model.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;

/**
 *
 * @author mhorvath
 */
@Entity
@Table(name = "book")
public class Book {
    @EmbeddedId
    BookIdentifier bookId;
    String style;

    public BookIdentifier getBookId() {
        return bookId;
    }

    public void setBookId(BookIdentifier bookId) {
        this.bookId = bookId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
}
