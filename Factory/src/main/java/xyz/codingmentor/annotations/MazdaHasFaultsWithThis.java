
package xyz.codingmentor.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *
 * @author mhorvath
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface MazdaHasFaultsWithThis {
    
}
