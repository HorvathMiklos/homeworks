
package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class UserAllreadyInUserListException  extends RuntimeException{

    public UserAllreadyInUserListException() {
        //nothing to initialize, method empty on purpose
    }

    public UserAllreadyInUserListException(String message) {
        super(message);
    }

    public UserAllreadyInUserListException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAllreadyInUserListException(Throwable cause) {
        super(cause);
    }

    public UserAllreadyInUserListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
