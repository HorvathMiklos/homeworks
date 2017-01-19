package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingDeviceException extends RuntimeException {

    public NotExistingDeviceException() {
        //nothing to inicialize empty on purpose
    }

    public NotExistingDeviceException(String deviceID) {
        super(deviceID);
    }

}
