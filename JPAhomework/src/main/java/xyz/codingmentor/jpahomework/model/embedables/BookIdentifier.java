
package xyz.codingmentor.jpahomework.model.embedables;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author mhorvath
 */
@Embeddable
public class BookIdentifier implements Serializable{
    String publisher;
    String title;

    public BookIdentifier() {
    }

    public BookIdentifier(String publisher, String title) {
        this.publisher = publisher;
        this.title = title;
    }
    
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
