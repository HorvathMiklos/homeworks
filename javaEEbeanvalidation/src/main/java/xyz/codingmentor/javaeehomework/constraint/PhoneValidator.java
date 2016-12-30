package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author mhorvath
 */
public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    @Override
    public void initialize(ValidPhone a) {
        //happy sonar
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        if (t != null) {
            return t.matches("^((06)|(\\+36))\\d{9}");
        }
        return true;
    }

}
