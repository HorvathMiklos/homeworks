
package xyz.codingmentor.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mhorvath
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new java.util.HashSet<>();
        addClasses(classes);
        return classes;
    }
    
   private void addClasses(Set<Class<?>> classes){
       classes.add(xyz.codingmentor.exeptions.RestServiceExceptionMapper.class);
       classes.add(xyz.codingmentor.restservices.UserRestService.class);
   }
    
}
