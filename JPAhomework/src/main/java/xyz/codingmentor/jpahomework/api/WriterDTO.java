
package xyz.codingmentor.jpahomework.api;

import java.util.Date;
import java.util.List;
import xyz.codingmentor.jpahomework.model.entities.Book;
import xyz.codingmentor.jpahomework.model.enums.Gender;

/**
 *
 * @author mhorvath
 */
public class WriterDTO {
    private Long id;
    private String name;
    private Gender gender;
    private Date dateOfBirth;
    private List<Book> writenBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getWritenBooks() {
        return writenBooks;
    }

    public void setWritenBooks(List<Book> writenBooks) {
        this.writenBooks = writenBooks;
    }
    
}
