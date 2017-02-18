package xyz.codingmentor.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingDeviceException extends EntityException {

    public NotExistingDeviceException() {
        //nothing to inicialize empty on purpose
    }

    public NotExistingDeviceException(String deviceID) {
        super(deviceID);
    }

}
