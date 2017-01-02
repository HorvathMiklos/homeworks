
package xyz.codingmentor.javaeehomework.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = FirstnameLastnameBothFilledOrNullAtTheSameTimeValidator.class)
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface FirstnameLastnameBothFilledOrNullAtTheSameTime {

    String message() default "{FirstnameLastnameBothFilledOrNullAtTheSameTime.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
