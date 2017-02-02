package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.Color;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.Manufacturer;

/**
 *
 * @author mhorvath
 */
public class SamsungIsNotGreenValidator implements ConstraintValidator<SamsungIsNotGreen, Device> {

    @Override
    public void initialize(SamsungIsNotGreen a) {
        //nothing to initialize, method empty on purpose
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
