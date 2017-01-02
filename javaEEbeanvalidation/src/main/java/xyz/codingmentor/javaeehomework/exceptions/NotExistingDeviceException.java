package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingDeviceException extends RuntimeException {

    public NotExistingDeviceException() {
        //nothing to initialize, method empty on purpose
    }

    public NotExistingDeviceException(String message) {
        super(message);
    }

    public NotExistingDeviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistingDeviceException(Throwable cause) {
        super(cause);
    }

    public NotExistingDeviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
