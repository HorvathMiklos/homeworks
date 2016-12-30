
package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.javaeehomework.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class FirstnameLastnameBothFilledOrNullAtTheSameTimeValidator implements ConstraintValidator<FirstnameLastnameBothFilledOrNullAtTheSameTime, UserEntity>{

    @Override
    public void initialize(FirstnameLastnameBothFilledOrNullAtTheSameTime a) {
    }

    @Override
    public boolean isValid(UserEntity value, ConstraintValidatorContext cvc) {
        if(value.getFirstname()!=null){
            return value.getLastname()!=null;
        }
        return value.getLastname()==null;
    }

}
