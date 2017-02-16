
package xyz.codingmentor.jpahomework.model.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import xyz.codingmentor.jpahomework.model.embedables.BookIdentifier;


/**
 *
 * @author mhorvath
 */
@Entity
@Table(name = "book")
@NamedQuery(name = "books.byStyle",query = "SELECT b FROM Book b WHERE b.style LIKE :style")             
public class Book implements Serializable{
    @EmbeddedId
    BookIdentifier bookIdentifier;
    String style; 
    
    public BookIdentifier getBookIdentifier() {
        return bookIdentifier;
    }

    public void setBookIdentifier(BookIdentifier bookIdentifier) {
        this.bookIdentifier = bookIdentifier;
    }
   
   
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Book{" + "bookIdentifier=" + bookIdentifier + ", style=" + style + '}';
    }
    
}
