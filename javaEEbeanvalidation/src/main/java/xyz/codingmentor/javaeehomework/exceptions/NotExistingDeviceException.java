package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingDeviceException extends RuntimeException {
   private final String deviceID;
   
   public NotExistingDeviceException(String deviceID){
       this.deviceID = deviceID;
   }

   @Override
   public String getMessage() {
       return "The entitiy : " + this.deviceID +  " does not exist!";
   }
}
