package xyz.codingmentor.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingUserException extends EntityException {

    public NotExistingUserException(String entityName) {
        super(entityName);
    }
}
