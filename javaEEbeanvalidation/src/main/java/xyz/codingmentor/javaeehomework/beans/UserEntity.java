
package xyz.codingmentor.javaeehomework.beans;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import xyz.codingmentor.javaeehomework.constraint.DateOfBirthBeforeRegistration;
import xyz.codingmentor.javaeehomework.constraint.FirstnameLastnameBothFilledOrNullAtTheSameTime;
import xyz.codingmentor.javaeehomework.constraint.ValidAddress;
import xyz.codingmentor.javaeehomework.constraint.ValidEmail;
import xyz.codingmentor.javaeehomework.constraint.ValidPastDate;
import xyz.codingmentor.javaeehomework.constraint.ValidPhone;

/**
 *
 * @author mhorvath
 */
@FirstnameLastnameBothFilledOrNullAtTheSameTime
@DateOfBirthBeforeRegistration
public class UserEntity {
    @NotNull
    @Size(min = 6)    
    String username;
    @NotNull
    @Size(min = 6)   
    @Pattern.List({
        @Pattern(regexp = ".*[a-z].*"),
        @Pattern(regexp = ".*[A-Z].*"),
        @Pattern(regexp = "(.*[1-9].*)|(.*[\\=\\+\\<\\>\\.\\,\\)].*)")
    })   
    String password;
    String firstname;
    String lastname;
    @ValidAddress
    String address;
    @ValidPhone
    String phone;
    @NotNull
    @ValidEmail
    String email;
    Sex sex;
    @NotNull
    @ValidPastDate
    Date registrationDate;
    @ValidPastDate
    Date lastModifiedDate;
    Date dateOfBirth;
    boolean admin;

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLastModifiedDate(Date lastodifiedDate) {
        this.lastModifiedDate = lastodifiedDate;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    void getRegistrationDate(Date time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Sex getSex() {
        return sex;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.email);
        return hash;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserEntity other = (UserEntity) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    
    
}
