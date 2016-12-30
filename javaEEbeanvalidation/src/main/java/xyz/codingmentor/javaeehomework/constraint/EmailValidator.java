package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author mhorvath
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public void initialize(ValidEmail a) {
        //happy sonar
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        if (t == null) {
            return false;
        }
        return t.matches("^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}");

    }

}
