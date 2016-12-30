
package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author mhorvath
 */
public class PositiveValidator implements ConstraintValidator<ValidPositive, Integer>{

    @Override
    public void initialize(ValidPositive a) {
    }

    @Override
    public boolean isValid(Integer t, ConstraintValidatorContext cvc) {
        if(t==null){
            return true;
        }
        return t>0;
        
    }
}
