package xyz.codingmentor.interceptor;

import java.util.Arrays;
import java.util.Set;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.annotations.Bean;
import xyz.codingmentor.exceptions.EntityException;
import xyz.codingmentor.exceptions.InvalidBeanExeption;

/**
 *
 * @author mhorvath
 */
@Interceptor
@Validateable
public class ValidationInterceptor {

    @AroundInvoke
    public Object validation(InvocationContext ic) throws Exception {
        validateParams(ic.getParameters());
        return ic.proceed();
    }

    private void validateParams(Object[] parameters) {
        if (null == parameters) {
            return;
        }
        Arrays.asList(parameters).stream().filter(p -> p.getClass().isAnnotationPresent(Bean.class)).forEach(this::validateBean);
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
