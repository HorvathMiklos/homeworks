
package xyz.codingmentor.jpahomework.api;

import java.util.Date;
import java.util.List;
import xyz.codingmentor.jpahomework.model.embedables.Address;
import xyz.codingmentor.jpahomework.model.entities.Book;
import xyz.codingmentor.jpahomework.model.enums.Gender;

/**
 *
 * @author mhorvath
 */
public class UserDTO {
    private Long id;
    private String name;
    private Gender gender;
    private Date dateOfBirth;
    private Date dateOfRegistration;
    private Address address;
    private List<Book> rentedBooks;

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
