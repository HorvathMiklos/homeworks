/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor.javaeehomework.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = DateOfBirthBeforeRegistrationValidator.class)
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface DateOfBirthBeforeRegistration {
   String message() default "{DateOfBirthBeforeRegistration.message}";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}
