package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author mhorvath
 */
public class NaturalNumberValidator implements ConstraintValidator<ValidNaturalNumber, Integer> {

    @Override
    public void initialize(ValidNaturalNumber a) {
        //happy sonar
    }

    @Override
    public boolean isValid(Integer t, ConstraintValidatorContext cvc) {
        if (t == null) {
            return true;
        }
        return t >= 0;
    }

}
