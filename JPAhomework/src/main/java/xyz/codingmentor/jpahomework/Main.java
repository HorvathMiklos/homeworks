
package xyz.codingmentor.jpahomework;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;

/**
 *
 * @author mhorvath
 */
public class Main {
    public static void main(String[] args) throws RepositoryException {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Application application = container.instance().select(Application.class).get();
        application.execute();
        weld.shutdown();
    }
}
