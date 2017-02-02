
package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.UserEntity;

/**
 *
 * @author mhorvath
 */
public class DateOfBirthBeforeRegistrationValidator implements ConstraintValidator<DateOfBirthBeforeRegistration, UserEntity> {

    @Override
    public void initialize(DateOfBirthBeforeRegistration a) {
        //nothing to initialize, method empty on purpose
    }

    @Override
    public boolean isValid(UserEntity user, ConstraintValidatorContext cvc) {
        if (user == null||user.getDateOfBirth() == null || user.getRegistrationDate() == null) {
            return true;
        }
        return user.getDateOfBirth().before(user.getRegistrationDate());        
    }

}
