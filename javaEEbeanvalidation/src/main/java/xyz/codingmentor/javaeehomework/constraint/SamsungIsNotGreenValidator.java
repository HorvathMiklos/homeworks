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
public class SamsungIsNotGreenValidator implements ConstraintValidator<SamsungIsNotGreen, Device> {

    @Override
    public void initialize(SamsungIsNotGreen a) {
        //happy sonar
    }

    @Override
    public boolean isValid(Device device, ConstraintValidatorContext cvc) {
        if (device == null) {
            return true;
        }
        if (device.getManufacturer() == Manufacturer.SAMSUNG) {
            return device.getColor() != Color.GREEN;
        }
        return true;
    }

}
