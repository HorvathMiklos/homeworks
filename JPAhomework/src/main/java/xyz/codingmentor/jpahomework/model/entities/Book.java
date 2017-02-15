
package xyz.codingmentor.jpahomework.model.entities;

import java.io.Serializable;
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
    
}
