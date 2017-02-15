
package xyz.codingmentor.jpahomework.model.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Writer {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "writer_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    //@ManyToMany(/*cascade = CascadeType.ALL*/)
    
    //private List<Book> writenBooks=new ArrayList<>();
    
    public Writer() {
    }
    /*
    public void addWritenBook(Book book){
        writenBooks.add(book);
    }
    */
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
/*
    public List<Book> getWritenBooks() {
        return writenBooks;
    }

    public void setWritenBooks(List<Book> writenBooks) {
        this.writenBooks = writenBooks;
    }
    */
}
