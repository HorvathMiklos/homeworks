package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mhorvath
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.rest.CategoryResource.class);
        resources.add(xyz.codingmentor.rest.JpqlRESTResource.class);
        resources.add(xyz.codingmentor.rest.MovieResource.class);
        resources.add(xyz.codingmentor.rest.MovieStarResource.class);
        resources.add(xyz.codingmentor.rest.TrailerResource.class);
        resources.add(xyz.codingmentor.rest.initResource.class);
    }
    
}
