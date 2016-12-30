package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.javaeehomework.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class FirstnameLastnameBothFilledOrNullAtTheSameTimeValidator implements ConstraintValidator<FirstnameLastnameBothFilledOrNullAtTheSameTime, UserEntity> {

    @Override
    public void initialize(FirstnameLastnameBothFilledOrNullAtTheSameTime a) {
        //happy sonar
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
