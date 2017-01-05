package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingUserException extends RuntimeException {
   public NotExistingUserException(String entityName){
       super(entityName);
   }
}
