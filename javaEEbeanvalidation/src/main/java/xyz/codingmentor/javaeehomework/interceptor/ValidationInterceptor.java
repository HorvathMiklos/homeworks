
package xyz.codingmentor.javaeehomework.interceptor;

import java.util.Arrays;
import java.util.Set;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;

import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.javaeehomework.annotations.Bean;
import xyz.codingmentor.javaeehomework.exceptions.InvalidBeanExeption;

/**
 *
 * @author mhorvath
 */
@Interceptor
@Validateable
public class ValidationInterceptor {
    @AroundInvoke
    public Object validation(InvocationContext ic) throws Exception{
        Arrays.asList(ic.getParameters()).stream().filter(parameter -> parameter.getClass().isAnnotationPresent(Bean.class)).forEach(this::validateBean);
        
        return ic.proceed();
    }
    
    private void validateBean(Object bean) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(bean);
         if (!violations.isEmpty()) {
            throw new InvalidBeanExeption(violations.toString());
        }
        
    }
}
