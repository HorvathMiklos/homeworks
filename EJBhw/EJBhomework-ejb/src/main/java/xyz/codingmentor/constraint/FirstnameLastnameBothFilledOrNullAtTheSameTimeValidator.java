
package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class FirstnameLastnameBothFilledOrNullAtTheSameTimeValidator implements ConstraintValidator<FirstnameLastnameBothFilledOrNullAtTheSameTime, UserEntity> {

    @Override
    public void initialize(FirstnameLastnameBothFilledOrNullAtTheSameTime a) {
        //nothing to initialize, method empty on purpose
    }

    @Override
    public boolean isValid(UserEntity user, ConstraintValidatorContext cvc) {
        if(user==null){
            return true;
        }
        if (user.getFirstname() != null) {
            return user.getLastname() != null;
        }
        return user.getLastname() == null;
    }

}
