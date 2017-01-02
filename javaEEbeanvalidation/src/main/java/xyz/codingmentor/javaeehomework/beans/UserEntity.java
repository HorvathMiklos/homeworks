package xyz.codingmentor.javaeehomework.beans;

import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import xyz.codingmentor.javaeehomework.constraint.DateOfBirthBeforeRegistration;
import xyz.codingmentor.javaeehomework.constraint.FirstnameLastnameBothFilledOrNullAtTheSameTime;

/**
 *
 * @author mhorvath
 */
@FirstnameLastnameBothFilledOrNullAtTheSameTime
@DateOfBirthBeforeRegistration
public class UserEntity {

    @NotNull
    @Size(min = 6)
    private String username;
    @NotNull
    @Size(min = 6)
    @Pattern.List({
        @Pattern(regexp = ".*[a-z].*"),
        @Pattern(regexp = ".*[A-Z].*"),
        @Pattern(regexp = "(.*[1-9].*)|(.*[\\=\\+\\<\\>\\.\\,\\)].*)")
    })
    private String password;
    private String firstname;
    private String lastname;
    @Pattern(regexp ="^\\d{4}.*")
    private String address;
    @Pattern(regexp ="^((06)|(\\+36))\\d{9}")
    private String phone;
    @NotNull
    @Pattern(regexp ="^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")        
    private String email;
    private Sex sex;
    @NotNull
    @Past
    private Date registrationDate;
    @Past
    private Date lastModifiedDate;
    private Date dateOfBirth;
    private boolean admin;

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
     public String getAddress() {
        return address;
    }
}
