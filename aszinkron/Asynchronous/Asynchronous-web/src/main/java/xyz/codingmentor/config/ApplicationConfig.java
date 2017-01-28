package xyz.codingmentor.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import xyz.codingmentor.restservice.RestService;

/**
 *
 * @author mhorvath
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application{
    
    private final Set<Class<?>> classes;
    public ApplicationConfig(){
        HashSet<Class<?>> c = new HashSet<>();     
        c.add(RestService.class);
        classes=Collections.unmodifiableSet(c);
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
    
}
