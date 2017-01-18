package xyz.codingmentor.javaeehomework.exceptions;

/**
 *
 * @author mhorvath
 */
public class NotExistingDeviceException extends RuntimeException {  
    public NotExistingDeviceException(String deviceID){
        super(deviceID);
   } 

    public NotExistingDeviceException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
