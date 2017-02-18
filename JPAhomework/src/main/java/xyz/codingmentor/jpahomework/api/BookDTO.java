
package xyz.codingmentor.jpahomework.api;

import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;

/**
 *
 * @author mhorvath
 */
public class BookDTO {
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
