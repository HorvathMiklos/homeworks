
package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.javaeehomework.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class DateOfBirthBeforeRegistrationValidator implements ConstraintValidator<DateOfBirthBeforeRegistration, UserEntity>{

    @Override
    public void initialize(DateOfBirthBeforeRegistration a) {
    }

    @Override
    public boolean isValid(UserEntity user, ConstraintValidatorContext cvc) {
        if(user==null){
            return true;
        }
        if(user.getDateOfBirth()==null||user.getRegistrationDate()==null){
            return true;
        }
        return 0>user.getDateOfBirth().compareTo(user.getRegistrationDate());
    }

}
