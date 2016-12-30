
package xyz.codingmentor.javaeehomework.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.javaeehomework.beans.Color;
import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.beans.Manufacturer;

/**
 *
 * @author mhorvath
 */
public class AppleBlackOrWhiteValidator implements ConstraintValidator<AppleBlackOrWhite, Device>{

    @Override
    public void initialize(AppleBlackOrWhite a) {
    }

    @Override
    public boolean isValid(Device device, ConstraintValidatorContext cvc) {
       if(device==null){
           return true;
       }
       if(device.getManufacturer()==Manufacturer.Apple){
           return device.getColor()==Color.BLACK||device.getColor()==Color.WHITE;
       }
       return true;
    }

}
