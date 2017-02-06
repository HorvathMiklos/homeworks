
package xyz.codingmentor.jpahomework.model.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import xyz.codingmentor.jpahomework.model.enums.Gender;

/**
 *
 * @author mhorvath
 */
@Entity
@Table(name = "writer")
public class Writer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "writer_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private List<Book> writenBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
