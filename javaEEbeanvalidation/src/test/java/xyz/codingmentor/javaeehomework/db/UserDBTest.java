/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor.javaeehomework.db;

import xyz.codingmentor.javaeehomework.exceptions.NotExistingUserException;
import java.util.Calendar;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import xyz.codingmentor.javaeehomework.beans.Sex;
import xyz.codingmentor.javaeehomework.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class UserDBTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private Calendar now;
    private UserEntity newUser;
    private UserEntity newUserBela;
    private UserEntity newUserJulia;
    private UserEntity newUserBelaModified;
    private UserDB userDB;

    public UserDBTest() {
    }

    @Before
    public void setUpClass() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
        userDB = new UserDB();
        Calendar beforeNow = Calendar.getInstance();
        beforeNow.add(Calendar.DAY_OF_YEAR, -165);
        Calendar longbeforeNow = Calendar.getInstance();
        longbeforeNow.add(Calendar.DAY_OF_YEAR, -365);
        newUser = new UserEntity("Firstname Lastname", "Admin112", "verycleveremailadress@companymail.com");
        newUser.setFirstname("Firstname");
        newUser.setLastname("Lastname");
        newUser.setAddress("1123 Java street 58");
        newUser.setPhone("06112358132");
        newUser.setSex(Sex.MALE);
        newUser.setRegistrationDate(beforeNow.getTime());
        newUser.setLastModifiedDate(beforeNow.getTime());
        newUser.setDateOfBirth(longbeforeNow.getTime());
        newUser.setAdmin(false);

        newUserBela = new UserEntity("Bela", "Admin112", "verycleveremailadress@companymail.com");
        newUserBela.setFirstname("Bela");
        newUserBela.setLastname("Lastname");
        newUserBela.setAddress("1123 Java street 58");
        newUserBela.setPhone("06112358132");
        newUserBela.setSex(Sex.MALE);
        newUserBela.setRegistrationDate(beforeNow.getTime());
        newUserBela.setLastModifiedDate(beforeNow.getTime());
        newUserBela.setDateOfBirth(longbeforeNow.getTime());
        newUserBela.setAdmin(false);

        newUserBelaModified = new UserEntity("Bela", "Admin112", "verycleveremailadress@companymail.com");
        newUserBelaModified.setFirstname("Bela");
        newUserBelaModified.setLastname("Lastname");
        newUserBelaModified.setAddress("1123 Somwhereelse street 58");
        newUserBelaModified.setPhone("06112358132");
        newUserBelaModified.setSex(Sex.MALE);
        newUserBelaModified.setRegistrationDate(beforeNow.getTime());
        newUserBelaModified.setLastModifiedDate(beforeNow.getTime());
        newUserBelaModified.setDateOfBirth(longbeforeNow.getTime());
        newUserBelaModified.setAdmin(false);

        newUserJulia = new UserEntity("Julia", "Admin112", "verycleveremailadress@companymail.com");
        newUserJulia.setFirstname("Julia");
        newUserJulia.setLastname("Lastname");
        newUserJulia.setAddress("1123 Java street 58");
        newUserJulia.setPhone("06112358132");
        newUserJulia.setSex(Sex.FEMALE);
        newUserJulia.setRegistrationDate(beforeNow.getTime());
        newUserJulia.setLastModifiedDate(beforeNow.getTime());
        newUserJulia.setDateOfBirth(longbeforeNow.getTime());
        newUserJulia.setAdmin(false);
    }

    /**
     * Test of addUser method, of class UserDB.
     */
    @Test
    public void testAddUser() {
        userDB.addUser(newUser);
        assertEquals(true, userDB.getAllUser().contains(newUser));
    }

    @Test
    public void testGetUser() {
        userDB.addUser(newUserBela);
        userDB.addUser(newUserJulia);
        assertEquals(newUserBela, userDB.getUser("Bela"));
        assertEquals(newUserJulia, userDB.getUser("Julia"));

    }

    @Test(expected = NotExistingUserException.class)
    public void testGetUserThrowsNotExistingUserException() {
        userDB.getUser("dgjhrktrsdrgstr");
    }

    @Test
    public void testAuthenticate() {
        assertEquals(false, userDB.authenticate("Bela", "wefweQWerf123wdfaseQ"));
        userDB.addUser(newUserJulia);
        assertEquals(true, userDB.authenticate("Julia", "Admin112"));
    }

    @Test
    public void testModifyUser() {
        userDB.addUser(newUserBela);
        assertEquals(newUserBelaModified, userDB.modifyUser(newUserBelaModified));
        assertEquals("1123 Somwhereelse street 58", userDB.getUser("Bela").getAddress());
    }

    @Test(expected = NotExistingUserException.class)
    public void testModifyUserThrowsNotExistingUserException() {
        userDB.modifyUser(newUserBelaModified);
    }

    @Test
    public void testDeleteUser() {
        userDB.addUser(newUserJulia);
        assertEquals(true, userDB.getAllUser().contains(newUserJulia));
        userDB.deleteUser(newUserJulia);
        assertEquals(false, userDB.getAllUser().contains(newUserJulia));
    }

    @Test(expected = NotExistingUserException.class)
    public void testDeleteUserThrowsNotExistingUserException() {
        userDB.deleteUser(newUserJulia);
    }

}
