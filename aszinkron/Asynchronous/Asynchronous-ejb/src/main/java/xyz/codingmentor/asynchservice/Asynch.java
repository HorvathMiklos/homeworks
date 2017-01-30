
package xyz.codingmentor.asynchservice;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;

/**
 *
 * @author mhorvath
 */

public class Asynch {
    private static final Logger LOGGER = Logger.getLogger(Asynch.class.getName());
    @Asynchronous
    public Future<Integer> inefectivlyReturnFive(){
        LOGGER.log(Level.INFO,"five started");
        final int i=5000;
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        LOGGER.log(Level.INFO,"five stopped");
        return new AsyncResult<>(i/1000);       
    }
    @Asynchronous
    public void doNothingForALongTime(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}
