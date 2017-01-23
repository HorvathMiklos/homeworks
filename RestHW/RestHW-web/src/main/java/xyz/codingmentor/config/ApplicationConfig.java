
package xyz.codingmentor.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import xyz.codingmentor.dto.ErrorDTO;
import xyz.codingmentor.entities.UserEntity;
import xyz.codingmentor.exeptions.NotMatchingIdExeption;
import xyz.codingmentor.exeptions.RestServiceExceptionMapper;
import xyz.codingmentor.restServices.UserRestService;

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
       classes.add(xyz.codingmentor.restServices.UserRestService.class);
   }
    
}
