package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingUserException extends RuntimeException {

    public NotExistingUserException() {
        //nothing to initialize, method empty on purpose
    }

    public NotExistingUserException(String message) {
        super(message);
    }

    public NotExistingUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistingUserException(Throwable cause) {
        super(cause);
    }

    public NotExistingUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
