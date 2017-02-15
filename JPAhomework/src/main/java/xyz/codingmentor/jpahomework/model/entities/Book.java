
package xyz.codingmentor.jpahomework.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
    
    //@ManyToMany(mappedBy = "rentedBooks")
    @OneToMany(cascade = {CascadeType.ALL})
    private List<User> rentedBy=new ArrayList<>();
    //@ManyToMany(mappedBy = "writenBooks")    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Writer> writenBy=new ArrayList<>();
    
    public void addWriter(Writer writer){
        writenBy.add(writer);
    }
    
    public void addUser(User user){
        rentedBy.add(user);
    }
    
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
