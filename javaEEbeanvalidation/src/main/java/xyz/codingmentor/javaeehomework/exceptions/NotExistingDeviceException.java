package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingDeviceException extends RuntimeException {  
    public NotExistingDeviceException(String deviceID){
        super(deviceID);
   } 
}
