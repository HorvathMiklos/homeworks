
package xyz.codingmentor.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingUserException extends RuntimeException {
   public NotExistingUserException(String entityName){
       super(entityName);
   }
}
