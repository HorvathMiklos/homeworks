
package xyz.codingmentor.jpahomework.model.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import xyz.codingmentor.jpahomework.api.UserDTO;
import xyz.codingmentor.jpahomework.model.embedables.Address;
import xyz.codingmentor.jpahomework.model.enums.Gender;

/**
 *
 * @author mhorvath
 */
@Entity
@Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable =
    false, updatable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "date_of_registration")
    @Temporal(TemporalType.DATE)
    private Date dateOfRegistration;
    @Embedded
    private Address address;
    @OneToMany
    private List<Book> rentedBooks;

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.gender = userDTO.getGender();
        this.dateOfBirth = userDTO.getDateOfBirth();
        this.dateOfRegistration = userDTO.getDateOfRegistration();
        this.address = userDTO.getAddress();
        this.rentedBooks = userDTO.getRentedBooks();
    }
    
    
    
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

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }
    
}
