
package xyz.codingmentor.jpahomework.model.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import xyz.codingmentor.jpahomework.api.BookDTO;

/**
 *
 * @author mhorvath
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    String title;
    String style;

    public Book(BookDTO bookDTO) {
        this.title = bookDTO.getTitle() ;
        this.style = bookDTO.getStyle();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
}
