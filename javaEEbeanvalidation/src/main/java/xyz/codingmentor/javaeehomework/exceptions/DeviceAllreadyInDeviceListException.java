
package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class DeviceAllreadyInDeviceListException extends RuntimeException{

    public DeviceAllreadyInDeviceListException() {
        //nothing to initialize, method empty on purpose
    }

    public DeviceAllreadyInDeviceListException(String message) {
        super(message);
    }

    public DeviceAllreadyInDeviceListException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceAllreadyInDeviceListException(Throwable cause) {
        super(cause);
    }

    public DeviceAllreadyInDeviceListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
