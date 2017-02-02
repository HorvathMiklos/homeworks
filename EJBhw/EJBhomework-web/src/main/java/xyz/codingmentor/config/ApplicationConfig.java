package xyz.codingmentor.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mhorvath
 */
@javax.ws.rs.ApplicationPath("web")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically populated with all resources defined in the project. If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.exception.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.restservices.CartRestService.class);
        resources.add(xyz.codingmentor.restservices.DeviceRestService.class);
        resources.add(xyz.codingmentor.restservices.UserRestService.class);
    }

}
