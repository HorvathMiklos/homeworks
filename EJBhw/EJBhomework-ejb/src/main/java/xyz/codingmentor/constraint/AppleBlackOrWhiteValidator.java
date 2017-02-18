package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.Color;
import xyz.codingmentor.beans.DeviceEntity;
import xyz.codingmentor.beans.Manufacturer;

/**
 *
 * @author mhorvath
 */
public class AppleBlackOrWhiteValidator implements ConstraintValidator<AppleBlackOrWhite, DeviceEntity> {

    @Override
    public void initialize(AppleBlackOrWhite a) {
        //nothing to initialize, method empty on purpose
    }

    @Override
    public boolean isValid(DeviceEntity device, ConstraintValidatorContext cvc) {
        if (device == null) {
            return true;
        }
        if (device.getManufacturer() == Manufacturer.APPLE) {
            return device.getColor() == Color.BLACK || device.getColor() == Color.WHITE;
        }
        return true;
    }

}
