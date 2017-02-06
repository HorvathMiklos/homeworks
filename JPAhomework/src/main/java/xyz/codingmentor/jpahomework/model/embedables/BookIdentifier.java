
package xyz.codingmentor.jpahomework.model.embedables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author mhorvath
 */
@Embeddable
public class BookIdentifier {
    @Column(name = "id_of_writer", nullable =
    false, updatable = false)
    String writerid;
    @Column(nullable =
    false, updatable = false)
    String title;

    public String getWriterid() {
        return writerid;
    }

    public void setWriterid(String writerid) {
        this.writerid = writerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    

    
}
