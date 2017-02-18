package xyz.codingmentor.asynchservice;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author mhorvath
 */
@Asynchronous
@Stateless
public class Asynch {

    private static final Logger LOGGER = Logger.getLogger(Asynch.class.getName());
    private static final int SLEEP_DURATION = 5000;

    public Future<Integer> inefectivlyReturnFive() {
        LOGGER.log(Level.INFO, "five started");
        try {
            Thread.sleep(SLEEP_DURATION);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, "interupted", ex);
            return new AsyncResult<>(0);
        }
        LOGGER.log(Level.INFO, "five finished");
        return new AsyncResult<>(5);
    }

    public void doNothingForALongTime() {
        LOGGER.log(Level.INFO, "nothing started");
        try {
            Thread.sleep(SLEEP_DURATION);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, "interupted", ex);
        }
        LOGGER.log(Level.INFO, "nothing finished");
    }
}
