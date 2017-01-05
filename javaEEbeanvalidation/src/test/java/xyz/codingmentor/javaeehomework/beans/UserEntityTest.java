
package xyz.codingmentor.javaeehomework.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class UserEntityTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private UserEntity newUser;

    public UserEntityTest() {
    }

    private <T> void testViolation(T violatedValue, int numbersOfViolations) {
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(newUser);
        Assert.assertEquals(numbersOfViolations, violations.size());
        if (violations.size() > 0) {
            Assert.assertEquals(violatedValue, violations.iterator().next().getInvalidValue());
        }
    }

    @Before
    public void setUp() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
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
    }

    @Test
    public void testUserEntityGood() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(newUser);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void testUserNameNull() {
        String badUsername = null;
        newUser.setUsername(badUsername);
        testViolation(badUsername, 1);
    }

    @Test
    public void testUserNameBad() {
        String badUsername = "bad";
        newUser.setUsername(badUsername);
        testViolation(badUsername, 1);
    }

    @Test
    public void testPasswordNull() {
        newUser.setPassword(null);
        testViolation(null, 1);
    }

    @Test
    public void testPasswordShort() {
        String shortPassword = "13Ab";
        newUser.setPassword(shortPassword);
        testViolation(shortPassword, 1);
    }

    @Test
    public void testPasswordBadRegex() {
        String badRegexPassword = "ABCDEFGHI1";
        newUser.setPassword(badRegexPassword);
        testViolation(badRegexPassword, 1);
    }

    @Test
    public void testBadAddress() {
        String badAddress = "1a234sfg";
        newUser.setAddress(badAddress);
        testViolation(badAddress, 1);
    }

    @Test
    public void testBadPhoneNumber() {
        String badPhoneNumber = "16123456789";
        newUser.setPhone(badPhoneNumber);
        testViolation(badPhoneNumber, 1);
    }

    @Test
    public void testEmailNull() {
        String badEmail = null;
        newUser.setEmail(badEmail);
        testViolation(badEmail, 1);
    }

    @Test
    public void testBadEmail() {
        String badEmail = "wefwefg@ewefwef.wergwertger";
        newUser.setEmail(badEmail);
        testViolation(badEmail, 1);
    }

    @Test
    public void testRegistratonDateBad() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_YEAR, 365);
        newUser.setRegistrationDate(futureDate.getTime());
        testViolation(futureDate.getTime(), 1);
    }

    @Test
    public void testRegistrationDateNull() {
        Date nullDate = null;
        newUser.setRegistrationDate(nullDate);
        testViolation(nullDate, 1);
    }

    @Test
    public void testDateOfBirthAfterRegistration() {
        Calendar beforeNow = Calendar.getInstance();
        beforeNow.add(Calendar.DAY_OF_YEAR, -165);
        Calendar longbeforeNow = Calendar.getInstance();
        longbeforeNow.add(Calendar.DAY_OF_YEAR, -365);
        newUser.setDateOfBirth(beforeNow.getTime());
        newUser.setRegistrationDate(longbeforeNow.getTime());
        testViolation(newUser, 1);
    }

    @AfterClass
    public static void close() {
        vf.close();
    }
}
