package xyz.codingmentor.javaeehomework.constraint;

import java.util.Calendar;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author mhorvath
 */
public class PastDateValidator implements ConstraintValidator<ValidPastDate, Date> {

    @Override
    public void initialize(ValidPastDate a) {
        //happy sonar
    }

    @Override
    public boolean isValid(Date t, ConstraintValidatorContext cvc) {
        if (t == null) {
            return false;
        }
        return 0 > t.compareTo(Calendar.getInstance().getTime());
    }

}
