
package xyz.codingmentor.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotEnoughDeviceExeption extends RuntimeException{

    public NotEnoughDeviceExeption() {
        //nothing to inicialize, empty on purpose
    }

    public NotEnoughDeviceExeption(String message) {
        super(message);
    }
    
}