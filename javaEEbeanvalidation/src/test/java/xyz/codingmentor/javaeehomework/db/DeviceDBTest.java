
package xyz.codingmentor.javaeehomework.db;

import xyz.codingmentor.javaeehomework.exceptions.NotExistingDeviceException;
import java.util.UUID;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import xyz.codingmentor.javaeehomework.beans.Color;
import xyz.codingmentor.javaeehomework.beans.Device;
import xyz.codingmentor.javaeehomework.beans.Manufacturer;


public class DeviceDBTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private Device newDeviceOne;
    private Device DeviceOneEdited;
    private Device newDeviceTwo;
    private DeviceDB deviceDB;
    private String iDOne, iDTwo, iDnotExisting;

    public DeviceDBTest() {

    }

    @Before
    public void setUp() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
        deviceDB = new DeviceDB();

        iDOne = UUID.randomUUID().toString();
        iDTwo = UUID.randomUUID().toString();
        iDnotExisting = UUID.randomUUID().toString();

        newDeviceOne = new Device();
        newDeviceOne.setId(iDOne);
        newDeviceOne.setManufacturer(Manufacturer.HTC);
        newDeviceOne.setType("phone");
        newDeviceOne.setPrice(1000);
        newDeviceOne.setColor(Color.BLUE);
        newDeviceOne.setCount(50);

        DeviceOneEdited = new Device();
        DeviceOneEdited.setId(iDOne);
        DeviceOneEdited.setManufacturer(Manufacturer.HTC);
        DeviceOneEdited.setType("phone");
        DeviceOneEdited.setPrice(1000);
        DeviceOneEdited.setColor(Color.BLUE);
        DeviceOneEdited.setCount(40);

        newDeviceTwo = new Device();
        newDeviceTwo.setId(iDTwo);
        newDeviceTwo.setManufacturer(Manufacturer.ONEPLUS);
        newDeviceTwo.setType("phone");
        newDeviceTwo.setPrice(1500);
        newDeviceTwo.setColor(Color.RED);
        newDeviceTwo.setCount(1000);
    }

    @Test
    public void testAddDevice() {
        deviceDB.addDevice(newDeviceOne);
        assertEquals(true, deviceDB.getAllDevices().contains(newDeviceOne));
    }

    @Test
    public void testEditDevice() {
        deviceDB.addDevice(newDeviceOne);
        assertEquals(newDeviceOne, deviceDB.editDevice(DeviceOneEdited));
        assertEquals(DeviceOneEdited.getCount(), deviceDB.getDevice(iDOne).getCount());

    }

    @Test(expected = NotExistingDeviceException.class)
    public void testEditDeviceThrowsNotExistingDeviceException() {
        deviceDB.editDevice(DeviceOneEdited);
    }

    @Test
    public void testGetDevice() {
        deviceDB.addDevice(newDeviceOne);
        deviceDB.addDevice(newDeviceTwo);
        assertEquals(newDeviceOne, deviceDB.getDevice(iDOne));
        assertEquals(newDeviceTwo, deviceDB.getDevice(iDTwo));
    }

    @Test(expected = NotExistingDeviceException.class)
    public void testGetDeviceThrowsNotExistingDeviceException() {
        deviceDB.getDevice(iDnotExisting);
    }

    @Test
    public void testDeleteDevice() {
        deviceDB.addDevice(newDeviceOne);
        deviceDB.addDevice(newDeviceTwo);
        deviceDB.deleteDevice(newDeviceTwo);
        assertEquals(true, deviceDB.getAllDevices().contains(newDeviceOne));
        assertEquals(false, deviceDB.getAllDevices().contains(newDeviceTwo));

    }

    @Test(expected = NotExistingDeviceException.class)
    public void testDeleteDeviceThrowsNotExistingDeviceException() {
        deviceDB.deleteDevice(newDeviceTwo);
    }

}
