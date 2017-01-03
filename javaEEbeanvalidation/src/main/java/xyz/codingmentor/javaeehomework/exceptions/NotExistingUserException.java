package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingUserException extends RuntimeException {

   private final String entityName;
   
   public NotExistingUserException(String entityName){
       this.entityName = entityName;
   }

   @Override
   public String getMessage() {
       return "The entitiy : " + this.entityName +  " does not exist!";
   }

}
