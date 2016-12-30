/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor.javaeehomework.beans;

import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author mhorvath
 */
public class DeviceTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private Device newDevice;

    public DeviceTest() {
    }

    private <T> void testViolation(T violatedValue, int numbersOfViolations) {
        Set<ConstraintViolation<Device>> violations = validator.validate(newDevice);
        Assert.assertEquals(numbersOfViolations, violations.size());
        if (violations.size() > 0) {
            Assert.assertEquals(violatedValue, violations.iterator().next().getInvalidValue());
        }
    }

    @Before
    public void setUpClass() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
        newDevice = new Device();
        newDevice.setId(UUID.randomUUID().toString());

        newDevice.setManufacturer(Manufacturer.HTC);
        newDevice.setType("phone");
        newDevice.setPrice(1000);
        newDevice.setColor(Color.BLUE);
        newDevice.setCount(50);
    }

    @Test
    public void testDeviceGood() {
        Set<ConstraintViolation<Device>> violations = validator.validate(newDevice);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void testIdNull() {
        String badId = null;
        newDevice.id = badId;
        testViolation(badId, 1);
    }

    @Test
    public void badUUID() {
        String badId = "09e503a1--e41-4d7a-acad-ba68fd73dddf";
        newDevice.id = badId;
        testViolation(badId, 1);
    }

    @Test
    public void shortId() {
        String badId = "09e503a1-0e41-4d7a-acad-ba68fd73ddd";
        newDevice.id = badId;
        testViolation(badId, 2);
    }

    @Test
    public void manufacturerNull() {
        Manufacturer nullManufacturer = null;
        newDevice.setManufacturer(nullManufacturer);
        testViolation(nullManufacturer, 1);
    }

    @Test
    public void typeNull() {
        String nulltype = null;
        newDevice.setType(nulltype);
        testViolation(nulltype, 1);
    }

    @Test
    public void typeShort() {
        String shortType = "ab";
        newDevice.setType(shortType);
        testViolation(shortType, 1);
    }

    @Test
    public void priceNull() {
        Integer nullPrice = null;
        newDevice.setPrice(nullPrice);
        testViolation(nullPrice, 1);
    }

    @Test
    public void priceZero() {
        Integer zeroPrice = 0;
        newDevice.setPrice(zeroPrice);
        testViolation(zeroPrice, 1);
    }

    @Test
    public void priceNegative() {
        Integer negativePrice = -1;
        newDevice.setPrice(negativePrice);
        testViolation(negativePrice, 1);
    }

    @Test
    public void colorNull() {
        Color nullColor = null;
        newDevice.setColor(nullColor);
        testViolation(nullColor, 1);
    }

    @Test
    public void countNull() {
        Integer nullCount = null;
        newDevice.setCount(nullCount);
        testViolation(nullCount, 1);
    }

    @Test
    public void countNegative() {
        Integer negativeCount = -1;
        newDevice.setCount(negativeCount);
        testViolation(negativeCount, 1);
    }

    @Test
    public void samsungGreen() {
        newDevice.setManufacturer(Manufacturer.SAMSUNG);
        newDevice.setColor(Color.GREEN);
        testViolation(newDevice, 1);
    }

    @Test
    public void appleNotBlackOrWhite() {
        newDevice.setManufacturer(Manufacturer.APPLE);
        newDevice.setColor(Color.GREEN);
        testViolation(newDevice, 1);
        newDevice.setColor(Color.BLUE);
        testViolation(newDevice, 1);
        newDevice.setColor(Color.PURPLE);
        testViolation(newDevice, 1);
        newDevice.setColor(Color.RED);
        testViolation(newDevice, 1);
    }
}
