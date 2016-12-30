
package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author mhorvath
 */
public class AddressValidator implements ConstraintValidator<ValidAddress, String>{

    @Override
    public void initialize(ValidAddress a) {
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        if (t != null) {
            return t.matches("^\\d{4}.*");
        }
        return true;
    }
}
